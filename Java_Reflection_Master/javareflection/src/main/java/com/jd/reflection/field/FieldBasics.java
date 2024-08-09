package com.jd.reflection.field;

import java.lang.reflect.Field;

public class FieldBasics {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Movie movie = new Movie("Lord of the Rings",
                2001,
                12.99,
                true,
                Category.ADVENTURE);

        printDeclaredFieldsInfo(Category.class, movie);

        Field minPriceStaticField = Movie.class.getDeclaredField("MINIMUM_PRICE");

        System.out.println(String.format("static MINIMUM_PRICE value :%f", minPriceStaticField.get(null)));
    }

    public static <T> void printDeclaredFieldsInfo(Class<? extends T> clazz, T instance) throws IllegalAccessException {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(String.format("Field name : %s type : %s",
                    field.getName(),
                    field.getType().getName()));

            System.out.println(String.format("Is synthetic field : %s", field.isSynthetic()));
            System.out.println(String.format("Field value is : %s", field.get(instance)));

            System.out.println();
        }
    }

    public enum Category {
        ADVENTURE,
        ACTION,
        COMEDY
    }

    public static class Movie extends Product {
        public static final double MINIMUM_PRICE = 10.99;

        private boolean isReleased;
        private Category category;
        private double actualPrice;

        public Movie(String name, int year, double price, boolean isReleased, Category category) {
            super(name, year);
            this.isReleased = isReleased;
            this.category = category;
            this.actualPrice = Math.max(price, MINIMUM_PRICE);
        }

        // Nested class
        public class MovieStats {
            private double timesWatched;

            public MovieStats(double timesWatched) {
                this.timesWatched = timesWatched;
            }

            public double getRevenue() {
                return timesWatched * actualPrice;
            }
        }
    }

    // Superclass
    public static class Product {
        protected String name;
        protected int year;
        protected double actualPrice;

        public Product(String name, int year) {
            this.name = name;
            this.year = year;
        }
    }
}
