
package by.epam.gems.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.epam.gems.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RussianGem_QNAME = new QName("http://www.example.com/gems", "russian-gem");
    private final static QName _PrivateGem_QNAME = new QName("http://www.example.com/gems", "private-gem");
    private final static QName _Gem_QNAME = new QName("http://www.example.com/gems", "gem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.epam.gems.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RussianGem }
     * 
     */
    public RussianGem createRussianGem() {
        return new RussianGem();
    }

    /**
     * Create an instance of {@link Gem }
     * 
     */
    public Gem createGem() {
        return new Gem();
    }

    /**
     * Create an instance of {@link Gems }
     * 
     */
    public Gems createGems() {
        return new Gems();
    }

    /**
     * Create an instance of {@link PrivateGem }
     * 
     */
    public PrivateGem createPrivateGem() {
        return new PrivateGem();
    }

    /**
     * Create an instance of {@link VisualParameters }
     * 
     */
    public VisualParameters createVisualParameters() {
        return new VisualParameters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RussianGem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/gems", name = "russian-gem", substitutionHeadNamespace = "http://www.example.com/gems", substitutionHeadName = "gem")
    public JAXBElement<RussianGem> createRussianGem(RussianGem value) {
        return new JAXBElement<RussianGem>(_RussianGem_QNAME, RussianGem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrivateGem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/gems", name = "private-gem", substitutionHeadNamespace = "http://www.example.com/gems", substitutionHeadName = "gem")
    public JAXBElement<PrivateGem> createPrivateGem(PrivateGem value) {
        return new JAXBElement<PrivateGem>(_PrivateGem_QNAME, PrivateGem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.com/gems", name = "gem")
    public JAXBElement<Gem> createGem(Gem value) {
        return new JAXBElement<Gem>(_Gem_QNAME, Gem.class, null, value);
    }

}
