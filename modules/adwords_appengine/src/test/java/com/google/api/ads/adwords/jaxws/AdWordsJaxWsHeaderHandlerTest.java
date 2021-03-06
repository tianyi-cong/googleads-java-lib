// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.jaxws;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.ads.adwords.jaxws.v201502.billing.BudgetOrderServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.ch.CustomerSyncServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.express.ExpressBusinessServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.express.PromotionServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.mcm.ManagedCustomerServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.o.TargetingIdeaServiceInterface;
import com.google.api.ads.adwords.jaxws.v201502.rm.AdwordsUserListServiceInterface;
import com.google.api.ads.adwords.lib.client.AdWordsServiceDescriptor;
import com.google.api.ads.adwords.lib.client.AdWordsServiceDescriptor.AdWordsSubProduct;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.conf.AdWordsApiConfiguration;
import com.google.api.ads.common.lib.client.HeaderHandler;
import com.google.api.ads.common.lib.conf.AdsLibConfiguration;
import com.google.api.ads.common.lib.exception.AuthenticationException;
import com.google.api.ads.common.lib.exception.ServiceException;
import com.google.api.ads.common.lib.soap.AuthorizationHeaderHandler;
import com.google.api.ads.common.lib.soap.jaxws.JaxWsHandler;
import com.google.api.ads.common.lib.useragent.UserAgentCombiner;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.SOAPElement;
import javax.xml.ws.BindingProvider;

/**
 * Tests for the {@link AdWordsJaxWsHeaderHandler} class.
 */
@RunWith(Parameterized.class)
public class AdWordsJaxWsHeaderHandlerTest {

  private AdWordsJaxWsHeaderHandler headerHandler;

  /** type of the AdWords service interface */
  private final Class<? extends Remote> interfaceClass;

  /** namespace for request header elements */
  private final String headerElementsNamespace;

  /** sub product of the interfaceClass */
  private final AdWordsSubProduct subProduct;

  private AdWordsSession adWordsSession;
  private AdWordsServiceDescriptor adWordsServiceDescriptor;
  
  @Mock
  private BindingProvider soapClient;
  @Mock
  private JaxWsHandler soapClientHandler;
  @Mock
  private AdWordsApiConfiguration adWordsApiConfiguration;
  @Mock
  private AdsLibConfiguration adsLibConfiguration;
  @Mock
  private AuthorizationHeaderHandler authorizationHeaderHandler;
  @Mock
  private UserAgentCombiner userAgentCombiner;

  private static final String DEVELOPER_TOKEN = "DEVELOPER_TOKEN";
  private static final String CLIENT_CUSTOMER_ID = "CLIENT_CUSTOMER_ID";
  private static final String USER_AGENT = "USER_AGENT";
  private static final String VERSION = "v201101";
  private static final Long EXPRESS_BUSINESS_ID = 123456789L;

  /**
   * Constructor.
   */
  public AdWordsJaxWsHeaderHandlerTest(Class<? extends Remote> interfaceClass,
      String headerElementsNamespace, AdWordsSubProduct subProduct) {
    this.interfaceClass = interfaceClass;
    this.headerElementsNamespace = headerElementsNamespace;
    this.subProduct = subProduct;
  }

  @Parameters(name="interface={0}, namespace={1}, subProduct={2}")
  public static Collection<Object[]> data() {
    Collection<Object[]> parameters = new ArrayList<Object[]>();
    // Test at least one standard interface for every subpackage of v201502
    parameters.add(
        new Object[] {BudgetOrderServiceInterface.class, "billing", AdWordsSubProduct.DEFAULT});
    parameters.add(
        new Object[] {CustomerSyncServiceInterface.class, "ch", AdWordsSubProduct.DEFAULT});
    parameters.add(new Object[] {CampaignServiceInterface.class, "cm", AdWordsSubProduct.DEFAULT});
    parameters.add(
        new Object[] {ManagedCustomerServiceInterface.class, "mcm", AdWordsSubProduct.DEFAULT});
    parameters.add(
        new Object[] {TargetingIdeaServiceInterface.class, "o", AdWordsSubProduct.DEFAULT});
    parameters.add(
        new Object[] {AdwordsUserListServiceInterface.class, "rm", AdWordsSubProduct.DEFAULT});
    parameters.add(
        new Object[] {ExpressBusinessServiceInterface.class, "express", AdWordsSubProduct.EXPRESS});
    parameters.add(
        new Object[] {PromotionServiceInterface.class, "express", AdWordsSubProduct.EXPRESS});
   return parameters;
  }

  @Before
  @SuppressWarnings("unchecked")
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    Map<AdWordsSubProduct, HeaderHandler<AdWordsSession, AdWordsServiceDescriptor>>
        subProductHandlerMap = Maps.newHashMap();
    subProductHandlerMap.put(AdWordsSubProduct.DEFAULT,
        new HeaderHandler.NoOpHeaderHandler<AdWordsSession, AdWordsServiceDescriptor>());
    subProductHandlerMap.put(AdWordsSubProduct.EXPRESS,
        new AdWordsJaxWsExpressHeaderHandler(soapClientHandler, adWordsApiConfiguration));
    
    headerHandler = new AdWordsJaxWsHeaderHandler(soapClientHandler,
        adWordsApiConfiguration,
        adsLibConfiguration,
        authorizationHeaderHandler,
        userAgentCombiner,
        subProductHandlerMap);

    adWordsSession = new AdWordsSession.Builder()
        .withClientCustomerId(CLIENT_CUSTOMER_ID)
        .withOAuth2Credential(new Credential(BearerToken.authorizationHeaderAccessMethod()))
        .withDeveloperToken(DEVELOPER_TOKEN)
        .withUserAgent(USER_AGENT)
        .build();
    
    adWordsServiceDescriptor =
        new AdWordsServiceDescriptor(interfaceClass, VERSION, adWordsApiConfiguration);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testSetHeaders() throws ServiceException, AuthenticationException {
    String namespacePrefix = "http://www.example.com";
    String topLevelNamespace =
        String.format("http://www.example.com/%s/v201101", headerElementsNamespace);
    String namespace = "http://www.example.com/cm/v201101";
    Map<String, String> expectedHeaders = new HashMap<String, String>();
    if (subProduct == AdWordsSubProduct.EXPRESS && adWordsSession.getExpressBusinessId() != null) {
      expectedHeaders.put("expressBusinessId", String.valueOf(EXPRESS_BUSINESS_ID));
    }

    String libSig = "libSig";
    adWordsSession.setValidateOnly(true);
    expectedHeaders.put("developerToken", DEVELOPER_TOKEN);
    expectedHeaders.put("clientCustomerId", CLIENT_CUSTOMER_ID);
    expectedHeaders.put("validateOnly", "true");
    expectedHeaders.put("userAgent", libSig);
    
    when(adWordsApiConfiguration.getNamespacePrefix()).thenReturn(namespacePrefix);
    when(adWordsApiConfiguration.getServiceSubProduct(eq(VERSION), anyString()))
        .thenReturn(subProduct);
    when(userAgentCombiner.getUserAgent(USER_AGENT)).thenReturn(libSig);

    headerHandler.setHeaders(soapClient, adWordsSession, adWordsServiceDescriptor);

    ArgumentCaptor<Object> headerArg = ArgumentCaptor.forClass(Object.class);
    verify(soapClientHandler).setHeader(eq(soapClient), (String) eq(null), (String) eq(null),
        headerArg.capture());

    if (headerArg.getValue() instanceof SOAPElement) {
      SOAPElement soapValue = (SOAPElement) headerArg.getValue();
      assertEquals("RequestHeader", soapValue.getLocalName());
      assertEquals(topLevelNamespace, soapValue.getNamespaceURI());
      ArrayList<SOAPElement> children = Lists.newArrayList(soapValue.getChildElements());
      assertEquals(expectedHeaders.size(), children.size());
      for (SOAPElement child : children) {
        assertEquals(namespace, child.getNamespaceURI());
        assertTrue(child.getLocalName(), expectedHeaders.containsKey(child.getLocalName()));
        assertEquals(child.getLocalName(), expectedHeaders.get(child.getLocalName()),
            child.getFirstChild().getTextContent().toString());
      }
    } else {
      fail("Generated headerValue is not a SOAPElement: " + headerArg.getValue());
    }
  }

  @Test
  public void testSetAuthenticationHeaders() throws Exception {
    Credential credential = new Credential(BearerToken.authorizationHeaderAccessMethod());
    Object soapClient = new Object();
    Map<String, Object> headerElements = new HashMap<String, Object>();
    AdWordsSession adWordsSession = new AdWordsSession.Builder().withOAuth2Credential(credential)
        .withDeveloperToken("developerToken").withUserAgent(USER_AGENT).build();
    String authHeader = "oAuTh2";
    Map<String, String> headersMap = new HashMap<String, String>();
    headersMap.put("Authorization", authHeader);

    headerHandler.setAuthenticationHeaders(soapClient, headerElements, adWordsSession);

    verify(authorizationHeaderHandler).setAuthorization(soapClient, adWordsSession);
  }
}
