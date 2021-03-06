
package by.maxsel.xmlstuff.entity;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RussianGem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RussianGem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.com/gems}Gem">
 *       &lt;sequence>
 *         &lt;element name="purchase-year" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RussianGem", namespace = "http://www.example.com/gems", propOrder = {
    "purchaseYear"
})
public class RussianGem
    extends Gem
{

    @XmlElement(name = "purchase-year", namespace = "http://www.example.com/gems", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger purchaseYear;

    /**
     * Gets the value of the purchaseYear property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPurchaseYear() {
        return purchaseYear;
    }

    /**
     * Sets the value of the purchaseYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPurchaseYear(BigInteger value) {
        this.purchaseYear = value;
    }

}
