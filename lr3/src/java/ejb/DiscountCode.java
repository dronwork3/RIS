/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "DISCOUNT_CODE")
@XmlRootElement
//Указываем статические именованные запросы
@NamedQueries({
    @NamedQuery(name = "DiscountCode.findAll", query = "SELECT d FROM DiscountCode d"),
    @NamedQuery(name = "DiscountCode.findByDiscountCode", query = "SELECT d FROM DiscountCode d WHERE d.discountCode = :discountCode"),
    @NamedQuery(name = "DiscountCode.findByRate", query = "SELECT d FROM DiscountCode d WHERE d.rate = :rate")})
public class DiscountCode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DISCOUNT_CODE")
  //Создаём одно поле с типом char.
    private Character discountCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    //Создаём графу
    @Column(name = "RATE")
  //Создаём класс с Неизменными знаковыми десятичными числами произвольной точности.
    private BigDecimal rate;
  //Определяеv многозначную связь с кратностью один ко многим.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountCode")
    private Collection<Customer> customerCollection;

    public DiscountCode() {
    }

//Создаём одно поле с типом char.
    public DiscountCode(Character discountCode) {
        this.discountCode = discountCode;
    }

//Создаём одно поле с типом char.
    public Character getDiscountCode() {
        return discountCode;
    }

//Создаём одно поле с типом char.
    public void setDiscountCode(Character discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

//Предотвращаем сопоставление свойства
    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

//Создаём переменные для редактирования и указываем их параметры
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountCode != null ? discountCode.hashCode() : 0);
        return hash;
    }

//Пишем свой метод equals()
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountCode)) {
            return false;
        }
        DiscountCode other = (DiscountCode) object;
        if ((this.discountCode == null && other.discountCode != null) || (this.discountCode != null && !this.discountCode.equals(other.discountCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.DiscountCode[ discountCode=" + discountCode + " ]";
    }

}
