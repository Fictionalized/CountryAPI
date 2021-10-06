package me.fictionalized.countries;

import me.fictionalized.countries.data.Request;
import me.fictionalized.countries.objects.Country;

public class Heart {

    public static void main(String[] args) {
        System.out.println("Testing!");

        Request request = new Request("can");

        Country canada = request.getCountry();
        System.out.println("Canada Capital:" + canada.getCapital());
    }

}
