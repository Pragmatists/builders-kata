package builders;

import static java.util.Arrays.*;
import static org.apache.commons.lang.builder.EqualsBuilder.*;
import static org.apache.commons.lang.builder.HashCodeBuilder.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;

public class ProductBuilderTest {

    @Test
    public void check_equality() {
        Product product = new Product(1L, "pencil", "sharp one",
                new Supplier("Pentel",
                        new Address("Osielsko", "pomorskie")),
                asList(new Price(BigDecimal.valueOf(5L), "PLN"),
                        new Price(BigDecimal.valueOf(1L), "EUR")));

        assertThat(product).isEqualTo(pencil());
    }

    @Test
    public void check_equality_with_fluent_setters() {
        // TODO
    }

    @Test
    public void check_equality_with_builder() {
        // TODO
    }

    @Test
    public void check_equality_with_nested_builders() {
        // TODO
    }

    private Product pencil() {
        return new Product(1L, "pencil", "sharp one",
                new Supplier("Pentel",
                        new Address("Osielsko", "pomorskie")),
                asList(new Price(BigDecimal.valueOf(5L), "PLN"),
                        new Price(BigDecimal.valueOf(1L), "EUR")));
    }

    static class Product {

        private Long id;

        private String name;

        private String description;

        private Supplier supplier;

        private Collection<Price> price;

        public Product(Long id, String name, String description, Supplier supplier, Collection<Price> price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.supplier = supplier;
            this.price = price;
        }

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }

    }

    static class Supplier {

        public Supplier(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        private String name;

        private Address address;

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }

    }

    static class Price {

        public Price(BigDecimal value, String currency) {
            this.value = value;
            this.currency = currency;
        }

        private BigDecimal value;

        private String currency;

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }
    }

    static class Address {

        public Address(String city, String state) {
            this.city = city;
            this.state = state;
        }

        private String city;

        private String state;

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }
    }

}
