package ejb;

import ejb.Customer;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-24T21:03:16")
@StaticMetamodel(DiscountCode.class)
public class DiscountCode_ { 

    public static volatile SingularAttribute<DiscountCode, Character> discountCode;
    public static volatile SingularAttribute<DiscountCode, BigDecimal> rate;
    public static volatile CollectionAttribute<DiscountCode, Customer> customerCollection;

}