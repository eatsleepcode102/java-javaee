/**
 * EBook.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package example.ebookstore.endpoint;

public class EBook  implements java.io.Serializable {
    private java.lang.String[] notes;

    private int numPages;

    private double price;

    private java.lang.String title;

    public EBook() {
    }

    public EBook(
           java.lang.String[] notes,
           int numPages,
           double price,
           java.lang.String title) {
           this.notes = notes;
           this.numPages = numPages;
           this.price = price;
           this.title = title;
    }


    /**
     * Gets the notes value for this EBook.
     * 
     * @return notes
     */
    public java.lang.String[] getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this EBook.
     * 
     * @param notes
     */
    public void setNotes(java.lang.String[] notes) {
        this.notes = notes;
    }

    public java.lang.String getNotes(int i) {
        return this.notes[i];
    }

    public void setNotes(int i, java.lang.String _value) {
        this.notes[i] = _value;
    }


    /**
     * Gets the numPages value for this EBook.
     * 
     * @return numPages
     */
    public int getNumPages() {
        return numPages;
    }


    /**
     * Sets the numPages value for this EBook.
     * 
     * @param numPages
     */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }


    /**
     * Gets the price value for this EBook.
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }


    /**
     * Sets the price value for this EBook.
     * 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * Gets the title value for this EBook.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this EBook.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EBook)) return false;
        EBook other = (EBook) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              java.util.Arrays.equals(this.notes, other.getNotes()))) &&
            this.numPages == other.getNumPages() &&
            this.price == other.getPrice() &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getNotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getNumPages();
        _hashCode += new Double(getPrice()).hashCode();
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EBook.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://endpoint.ebookstore.example/", "eBook"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numPages");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numPages"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("price");
        elemField.setXmlName(new javax.xml.namespace.QName("", "price"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
