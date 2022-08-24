package com.interview.miscellaneous;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {

    public void validateIpAddress(){
        String ip = "300.12.12.034";
        if (ip == null)
            System.out.println("not valid");

        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String regex = zeroTo255 + "." + zeroTo255 + "." + zeroTo255 + "." + zeroTo255;

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);
        System.out.println(m.matches());
    }

    public void validateIpAddress_2() throws UnknownHostException {
        String ip = "300.12.12.034";
        if (ip == null)
            System.out.println("not valid");

        InetAddress i = InetAddress.getLocalHost();
        System.out.println("local ip address : "+i.getHostAddress().trim());

        /*InetAddressValidator validator = InetAddressValidator.getInstance();

        System.out.println(validator.isValidInet4Address(ip) ? true : false);
        System.out.println(validator.isValidInet6Address(ip) ? true : false);*/
    }
}
