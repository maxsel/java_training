
package by.epam.gems.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VisualParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisualParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="color">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Black"/>
 *               &lt;enumeration value="Blue"/>
 *               &lt;enumeration value="Blue-white"/>
 *               &lt;enumeration value="Brown"/>
 *               &lt;enumeration value="Colorless"/>
 *               &lt;enumeration value="Green"/>
 *               &lt;enumeration value="Orange"/>
 *               &lt;enumeration value="Pink"/>
 *               &lt;enumeration value="Red"/>
 *               &lt;enumeration value="White"/>
 *               &lt;enumeration value="Yellow"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="opacity">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;maxInclusive value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cut-type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger">
 *               &lt;minInclusive value="4"/>
 *               &lt;maxInclusive value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisualParameters", namespace = "http://www.example.com/gems", propOrder = {
    "color",
    "opacity",
    "cutType"
})
public class VisualParameters {

    @XmlElement(namespace = "http://www.example.com/gems", required = true)
    protected String color;
    @XmlElement(namespace = "http://www.example.com/gems")
    protected int opacity;
    @XmlElement(name = "cut-type", namespace = "http://www.example.com/gems")
    protected int cutType;

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the opacity property.
     * 
     */
    public int getOpacity() {
        return opacity;
    }

    /**
     * Sets the value of the opacity property.
     * 
     */
    public void setOpacity(int value) {
        this.opacity = value;
    }

    /**
     * Gets the value of the cutType property.
     * 
     */
    public int getCutType() {
        return cutType;
    }

    /**
     * Sets the value of the cutType property.
     * 
     */
    public void setCutType(int value) {
        this.cutType = value;
    }

}
