/**
 * DtCurso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtCurso  implements java.io.Serializable {
    private java.lang.String nombre;

    private java.lang.String descripcion;

    private java.lang.String duracion;

    private int cantHoras;

    private int creditos;

    private java.util.Calendar fechaR;

    private java.lang.String url;

    private java.lang.String instituto;

    private java.lang.String imagenURL;

    private java.lang.String[] ediciones;

    private java.lang.String[] programas;

    private java.lang.String[] previas;

    private java.lang.String[] categorias;

    public DtCurso() {
    }

    public DtCurso(
           java.lang.String nombre,
           java.lang.String descripcion,
           java.lang.String duracion,
           int cantHoras,
           int creditos,
           java.util.Calendar fechaR,
           java.lang.String url,
           java.lang.String instituto,
           java.lang.String imagenURL,
           java.lang.String[] ediciones,
           java.lang.String[] programas,
           java.lang.String[] previas,
           java.lang.String[] categorias) {
           this.nombre = nombre;
           this.descripcion = descripcion;
           this.duracion = duracion;
           this.cantHoras = cantHoras;
           this.creditos = creditos;
           this.fechaR = fechaR;
           this.url = url;
           this.instituto = instituto;
           this.imagenURL = imagenURL;
           this.ediciones = ediciones;
           this.programas = programas;
           this.previas = previas;
           this.categorias = categorias;
    }


    /**
     * Gets the nombre value for this DtCurso.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DtCurso.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the descripcion value for this DtCurso.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DtCurso.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the duracion value for this DtCurso.
     * 
     * @return duracion
     */
    public java.lang.String getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this DtCurso.
     * 
     * @param duracion
     */
    public void setDuracion(java.lang.String duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the cantHoras value for this DtCurso.
     * 
     * @return cantHoras
     */
    public int getCantHoras() {
        return cantHoras;
    }


    /**
     * Sets the cantHoras value for this DtCurso.
     * 
     * @param cantHoras
     */
    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }


    /**
     * Gets the creditos value for this DtCurso.
     * 
     * @return creditos
     */
    public int getCreditos() {
        return creditos;
    }


    /**
     * Sets the creditos value for this DtCurso.
     * 
     * @param creditos
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


    /**
     * Gets the fechaR value for this DtCurso.
     * 
     * @return fechaR
     */
    public java.util.Calendar getFechaR() {
        return fechaR;
    }


    /**
     * Sets the fechaR value for this DtCurso.
     * 
     * @param fechaR
     */
    public void setFechaR(java.util.Calendar fechaR) {
        this.fechaR = fechaR;
    }


    /**
     * Gets the url value for this DtCurso.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DtCurso.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the instituto value for this DtCurso.
     * 
     * @return instituto
     */
    public java.lang.String getInstituto() {
        return instituto;
    }


    /**
     * Sets the instituto value for this DtCurso.
     * 
     * @param instituto
     */
    public void setInstituto(java.lang.String instituto) {
        this.instituto = instituto;
    }


    /**
     * Gets the imagenURL value for this DtCurso.
     * 
     * @return imagenURL
     */
    public java.lang.String getImagenURL() {
        return imagenURL;
    }


    /**
     * Sets the imagenURL value for this DtCurso.
     * 
     * @param imagenURL
     */
    public void setImagenURL(java.lang.String imagenURL) {
        this.imagenURL = imagenURL;
    }


    /**
     * Gets the ediciones value for this DtCurso.
     * 
     * @return ediciones
     */
    public java.lang.String[] getEdiciones() {
        return ediciones;
    }


    /**
     * Sets the ediciones value for this DtCurso.
     * 
     * @param ediciones
     */
    public void setEdiciones(java.lang.String[] ediciones) {
        this.ediciones = ediciones;
    }

    public java.lang.String getEdiciones(int i) {
        return this.ediciones[i];
    }

    public void setEdiciones(int i, java.lang.String _value) {
        this.ediciones[i] = _value;
    }


    /**
     * Gets the programas value for this DtCurso.
     * 
     * @return programas
     */
    public java.lang.String[] getProgramas() {
        return programas;
    }


    /**
     * Sets the programas value for this DtCurso.
     * 
     * @param programas
     */
    public void setProgramas(java.lang.String[] programas) {
        this.programas = programas;
    }

    public java.lang.String getProgramas(int i) {
        return this.programas[i];
    }

    public void setProgramas(int i, java.lang.String _value) {
        this.programas[i] = _value;
    }


    /**
     * Gets the previas value for this DtCurso.
     * 
     * @return previas
     */
    public java.lang.String[] getPrevias() {
        return previas;
    }


    /**
     * Sets the previas value for this DtCurso.
     * 
     * @param previas
     */
    public void setPrevias(java.lang.String[] previas) {
        this.previas = previas;
    }

    public java.lang.String getPrevias(int i) {
        return this.previas[i];
    }

    public void setPrevias(int i, java.lang.String _value) {
        this.previas[i] = _value;
    }


    /**
     * Gets the categorias value for this DtCurso.
     * 
     * @return categorias
     */
    public java.lang.String[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this DtCurso.
     * 
     * @param categorias
     */
    public void setCategorias(java.lang.String[] categorias) {
        this.categorias = categorias;
    }

    public java.lang.String getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, java.lang.String _value) {
        this.categorias[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtCurso)) return false;
        DtCurso other = (DtCurso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.duracion==null && other.getDuracion()==null) || 
             (this.duracion!=null &&
              this.duracion.equals(other.getDuracion()))) &&
            this.cantHoras == other.getCantHoras() &&
            this.creditos == other.getCreditos() &&
            ((this.fechaR==null && other.getFechaR()==null) || 
             (this.fechaR!=null &&
              this.fechaR.equals(other.getFechaR()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.instituto==null && other.getInstituto()==null) || 
             (this.instituto!=null &&
              this.instituto.equals(other.getInstituto()))) &&
            ((this.imagenURL==null && other.getImagenURL()==null) || 
             (this.imagenURL!=null &&
              this.imagenURL.equals(other.getImagenURL()))) &&
            ((this.ediciones==null && other.getEdiciones()==null) || 
             (this.ediciones!=null &&
              java.util.Arrays.equals(this.ediciones, other.getEdiciones()))) &&
            ((this.programas==null && other.getProgramas()==null) || 
             (this.programas!=null &&
              java.util.Arrays.equals(this.programas, other.getProgramas()))) &&
            ((this.previas==null && other.getPrevias()==null) || 
             (this.previas!=null &&
              java.util.Arrays.equals(this.previas, other.getPrevias()))) &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias())));
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
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDuracion() != null) {
            _hashCode += getDuracion().hashCode();
        }
        _hashCode += getCantHoras();
        _hashCode += getCreditos();
        if (getFechaR() != null) {
            _hashCode += getFechaR().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getInstituto() != null) {
            _hashCode += getInstituto().hashCode();
        }
        if (getImagenURL() != null) {
            _hashCode += getImagenURL().hashCode();
        }
        if (getEdiciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEdiciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEdiciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProgramas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProgramas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProgramas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrevias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPrevias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPrevias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtCurso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtCurso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instituto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instituto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagenURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagenURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ediciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ediciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("previas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "previas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
