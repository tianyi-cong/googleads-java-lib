/**
 * FunctionErrorReason.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Mar 02, 2009 (07:08:06 PST) WSDL2Java emitter.
 */

package com.google.api.ads.adwords.axis.v201506.cm;

public class FunctionErrorReason implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected FunctionErrorReason(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _INVALID_FUNCTION_FORMAT = "INVALID_FUNCTION_FORMAT";
    public static final java.lang.String _DATA_TYPE_MISMATCH = "DATA_TYPE_MISMATCH";
    public static final java.lang.String _INVALID_CONJUNCTION_OPERANDS = "INVALID_CONJUNCTION_OPERANDS";
    public static final java.lang.String _INVALID_NUMBER_OF_OPERANDS = "INVALID_NUMBER_OF_OPERANDS";
    public static final java.lang.String _INVALID_OPERAND_TYPE = "INVALID_OPERAND_TYPE";
    public static final java.lang.String _INVALID_OPERATOR = "INVALID_OPERATOR";
    public static final java.lang.String _INVALID_REQUEST_CONTEXT_TYPE = "INVALID_REQUEST_CONTEXT_TYPE";
    public static final java.lang.String _INVALID_FUNCTION_FOR_CALL_PLACEHOLDER = "INVALID_FUNCTION_FOR_CALL_PLACEHOLDER";
    public static final java.lang.String _INVALID_FUNCTION_FOR_PLACEHOLDER = "INVALID_FUNCTION_FOR_PLACEHOLDER";
    public static final java.lang.String _INVALID_OPERAND = "INVALID_OPERAND";
    public static final java.lang.String _MISSING_CONSTANT_OPERAND_VALUE = "MISSING_CONSTANT_OPERAND_VALUE";
    public static final java.lang.String _INVALID_CONSTANT_OPERAND_VALUE = "INVALID_CONSTANT_OPERAND_VALUE";
    public static final java.lang.String _INVALID_NESTING = "INVALID_NESTING";
    public static final java.lang.String _MULTIPLE_FEED_IDS_NOT_SUPPORTED = "MULTIPLE_FEED_IDS_NOT_SUPPORTED";
    public static final java.lang.String _INVALID_ATTRIBUTE_NAME = "INVALID_ATTRIBUTE_NAME";
    public static final java.lang.String _UNKNOWN = "UNKNOWN";
    public static final FunctionErrorReason INVALID_FUNCTION_FORMAT = new FunctionErrorReason(_INVALID_FUNCTION_FORMAT);
    public static final FunctionErrorReason DATA_TYPE_MISMATCH = new FunctionErrorReason(_DATA_TYPE_MISMATCH);
    public static final FunctionErrorReason INVALID_CONJUNCTION_OPERANDS = new FunctionErrorReason(_INVALID_CONJUNCTION_OPERANDS);
    public static final FunctionErrorReason INVALID_NUMBER_OF_OPERANDS = new FunctionErrorReason(_INVALID_NUMBER_OF_OPERANDS);
    public static final FunctionErrorReason INVALID_OPERAND_TYPE = new FunctionErrorReason(_INVALID_OPERAND_TYPE);
    public static final FunctionErrorReason INVALID_OPERATOR = new FunctionErrorReason(_INVALID_OPERATOR);
    public static final FunctionErrorReason INVALID_REQUEST_CONTEXT_TYPE = new FunctionErrorReason(_INVALID_REQUEST_CONTEXT_TYPE);
    public static final FunctionErrorReason INVALID_FUNCTION_FOR_CALL_PLACEHOLDER = new FunctionErrorReason(_INVALID_FUNCTION_FOR_CALL_PLACEHOLDER);
    public static final FunctionErrorReason INVALID_FUNCTION_FOR_PLACEHOLDER = new FunctionErrorReason(_INVALID_FUNCTION_FOR_PLACEHOLDER);
    public static final FunctionErrorReason INVALID_OPERAND = new FunctionErrorReason(_INVALID_OPERAND);
    public static final FunctionErrorReason MISSING_CONSTANT_OPERAND_VALUE = new FunctionErrorReason(_MISSING_CONSTANT_OPERAND_VALUE);
    public static final FunctionErrorReason INVALID_CONSTANT_OPERAND_VALUE = new FunctionErrorReason(_INVALID_CONSTANT_OPERAND_VALUE);
    public static final FunctionErrorReason INVALID_NESTING = new FunctionErrorReason(_INVALID_NESTING);
    public static final FunctionErrorReason MULTIPLE_FEED_IDS_NOT_SUPPORTED = new FunctionErrorReason(_MULTIPLE_FEED_IDS_NOT_SUPPORTED);
    public static final FunctionErrorReason INVALID_ATTRIBUTE_NAME = new FunctionErrorReason(_INVALID_ATTRIBUTE_NAME);
    public static final FunctionErrorReason UNKNOWN = new FunctionErrorReason(_UNKNOWN);
    public java.lang.String getValue() { return _value_;}
    public static FunctionErrorReason fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        FunctionErrorReason enumeration = (FunctionErrorReason)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static FunctionErrorReason fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FunctionErrorReason.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://adwords.google.com/api/adwords/cm/v201506", "FunctionError.Reason"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
