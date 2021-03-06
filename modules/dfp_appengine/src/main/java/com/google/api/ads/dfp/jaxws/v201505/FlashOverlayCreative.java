
package com.google.api.ads.dfp.jaxws.v201505;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             An overlay {@code Creative} that displays a Flash-based ad and is
 *             served via VAST 2.0 XML. Overlays cover part of the video content
 *             they are displayed on top of.  This creative is read-only.
 *           
 * 
 * <p>Java class for FlashOverlayCreative complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlashOverlayCreative">
 *   &lt;complexContent>
 *     &lt;extension base="{https://www.google.com/apis/ads/publisher/v201505}BaseFlashCreative">
 *       &lt;sequence>
 *         &lt;element name="companionCreativeIds" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="trackingUrls" type="{https://www.google.com/apis/ads/publisher/v201505}ConversionEvent_TrackingUrlsMapEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="customParameters" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apiFramework" type="{https://www.google.com/apis/ads/publisher/v201505}ApiFramework" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vastPreviewUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lockedOrientation" type="{https://www.google.com/apis/ads/publisher/v201505}LockedOrientation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlashOverlayCreative", propOrder = {
    "companionCreativeIds",
    "trackingUrls",
    "customParameters",
    "apiFramework",
    "duration",
    "vastPreviewUrl",
    "lockedOrientation"
})
public class FlashOverlayCreative
    extends BaseFlashCreative
{

    @XmlElement(type = Long.class)
    protected List<Long> companionCreativeIds;
    protected List<ConversionEventTrackingUrlsMapEntry> trackingUrls;
    protected String customParameters;
    @XmlSchemaType(name = "string")
    protected ApiFramework apiFramework;
    protected Integer duration;
    protected String vastPreviewUrl;
    @XmlSchemaType(name = "string")
    protected LockedOrientation lockedOrientation;

    /**
     * Gets the value of the companionCreativeIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the companionCreativeIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompanionCreativeIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getCompanionCreativeIds() {
        if (companionCreativeIds == null) {
            companionCreativeIds = new ArrayList<Long>();
        }
        return this.companionCreativeIds;
    }

    /**
     * Gets the value of the trackingUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackingUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackingUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConversionEventTrackingUrlsMapEntry }
     * 
     * 
     */
    public List<ConversionEventTrackingUrlsMapEntry> getTrackingUrls() {
        if (trackingUrls == null) {
            trackingUrls = new ArrayList<ConversionEventTrackingUrlsMapEntry>();
        }
        return this.trackingUrls;
    }

    /**
     * Gets the value of the customParameters property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomParameters() {
        return customParameters;
    }

    /**
     * Sets the value of the customParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomParameters(String value) {
        this.customParameters = value;
    }

    /**
     * Gets the value of the apiFramework property.
     * 
     * @return
     *     possible object is
     *     {@link ApiFramework }
     *     
     */
    public ApiFramework getApiFramework() {
        return apiFramework;
    }

    /**
     * Sets the value of the apiFramework property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiFramework }
     *     
     */
    public void setApiFramework(ApiFramework value) {
        this.apiFramework = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDuration(Integer value) {
        this.duration = value;
    }

    /**
     * Gets the value of the vastPreviewUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVastPreviewUrl() {
        return vastPreviewUrl;
    }

    /**
     * Sets the value of the vastPreviewUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVastPreviewUrl(String value) {
        this.vastPreviewUrl = value;
    }

    /**
     * Gets the value of the lockedOrientation property.
     * 
     * @return
     *     possible object is
     *     {@link LockedOrientation }
     *     
     */
    public LockedOrientation getLockedOrientation() {
        return lockedOrientation;
    }

    /**
     * Sets the value of the lockedOrientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LockedOrientation }
     *     
     */
    public void setLockedOrientation(LockedOrientation value) {
        this.lockedOrientation = value;
    }

}
