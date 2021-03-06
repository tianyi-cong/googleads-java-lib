
package com.google.api.ads.dfp.jaxws.v201505;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 *       Service for handling {@link SharedAdUnit} objects.
 *     
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SharedAdUnitServiceInterface", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SharedAdUnitServiceInterface {


    /**
     * 
     *         Gets a {@link SharedAdUnitPage} of {@link SharedAdUnit} objects that satisfy the given
     *         {@link Statement#query}. The following fields are supported for filtering:
     *         
     *         <table>
     *         <tr>
     *         <th scope="col">PQL Property</th> <th scope="col">Object Property</th>
     *         </tr>
     *         <tr>
     *         <td>{@code id}</td>
     *         <td>{@link SharedAdUnit#id}</td>
     *         </tr>
     *         <tr>
     *         <td>{@code name}</td>
     *         <td>{@link SharedAdUnit#name}</td>
     *         </tr>
     *         </table>
     *         
     *         @param filterStatement a Publisher Query Language statement used to filter
     *         a set of shared ad units
     *         @return the shared ad units that match the given filter
     *       
     * 
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201505.SharedAdUnitPage
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
    @RequestWrapper(localName = "getSharedAdUnitsByStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505", className = "com.google.api.ads.dfp.jaxws.v201505.SharedAdUnitServiceInterfacegetSharedAdUnitsByStatement")
    @ResponseWrapper(localName = "getSharedAdUnitsByStatementResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505", className = "com.google.api.ads.dfp.jaxws.v201505.SharedAdUnitServiceInterfacegetSharedAdUnitsByStatementResponse")
    public SharedAdUnitPage getSharedAdUnitsByStatement(
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
        Statement filterStatement)
        throws ApiException_Exception
    ;

    /**
     * 
     *         Performs actions on shared ad unit objects that match the given
     *         {@link Statement#query}.
     *         
     *         @param sharedAdUnitAction the action to perform
     *         @param filterStatement a Publisher Query Language statement used to filter
     *         a set of shared ad units
     *         @return the result of the update action, which contains the number of shared ad units
     *         on which the action was performed.
     *       
     * 
     * @param sharedAdUnitAction
     * @param filterStatement
     * @return
     *     returns com.google.api.ads.dfp.jaxws.v201505.UpdateResult
     * @throws ApiException_Exception
     */
    @WebMethod
    @WebResult(name = "rval", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
    @RequestWrapper(localName = "performSharedAdUnitAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505", className = "com.google.api.ads.dfp.jaxws.v201505.SharedAdUnitServiceInterfaceperformSharedAdUnitAction")
    @ResponseWrapper(localName = "performSharedAdUnitActionResponse", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505", className = "com.google.api.ads.dfp.jaxws.v201505.SharedAdUnitServiceInterfaceperformSharedAdUnitActionResponse")
    public UpdateResult performSharedAdUnitAction(
        @WebParam(name = "sharedAdUnitAction", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
        SharedAdUnitAction sharedAdUnitAction,
        @WebParam(name = "filterStatement", targetNamespace = "https://www.google.com/apis/ads/publisher/v201505")
        Statement filterStatement)
        throws ApiException_Exception
    ;

}
