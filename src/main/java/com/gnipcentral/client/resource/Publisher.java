package com.gnipcentral.client.resource;

import javax.xml.bind.annotation.*;
import java.util.Set;
import java.util.HashSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisherType")
@XmlRootElement(name = "publisher")
public class Publisher implements Resource {

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "uriTypeSafe")    
    private String name;

    @XmlElementWrapper(name="supportedRuleTypes")
    @XmlElement(name = "type", required = true)
    protected HashSet<RuleType> ruleTypes;
    
    @SuppressWarnings({"UnusedDeclaration"})
    private Publisher() {
        // private ctor for jaxb
    }

    public Publisher(String name) {
        this.name = name;
        this.ruleTypes = new HashSet<RuleType>();
    }

    public Publisher(String name, Set<RuleType> ruleTypes) {
        this.name = name;
        this.ruleTypes = new HashSet<RuleType>(ruleTypes);
    }

    public Publisher(String name, RuleType ... ruleTypes) {        
        this.name = name;
        this.ruleTypes = new HashSet<RuleType>(ruleTypes.length);
        for(RuleType ruleType : ruleTypes) {
            this.ruleTypes.add(ruleType);
        }
    }

    public String getName() {
        return name;
    }

    public Set<RuleType> getSupportedRuleTypes() {
        return new HashSet<RuleType>(ruleTypes);
    }

    public void addSupportedRuleType(RuleType ruleType) {
        ruleTypes.add(ruleType);
    }

    public void removeSupportedRuleType(RuleType ruleType) {
        ruleTypes.remove(ruleType);
    }

    public boolean hasSupportedRuleType(RuleType ruleType) {
        return ruleTypes.contains(ruleType);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (name != null ? !name.equals(publisher.name) : publisher.name != null) return false;

        return true;
    }

    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }
}