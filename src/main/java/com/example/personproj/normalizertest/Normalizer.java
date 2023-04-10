package com.example.personproj.normalizertest;

public class Normalizer {


  /*  public static String normalize(String string) {
        if (string == null || string.isEmpty()) {
            return "http://localhost:80/";
        }

        String[] parts = string.split("://");
        String protocol = parts.length > 1 ? parts[0] : "http";
        String[] domainAndPort = parts.length > 1 ? parts[1].split("/", 2)[0].split(":") : parts[0].split("/", 2)[0].split(":");
        String domain = domainAndPort.length > 0 ? domainAndPort[0] : "localhost";
        int port = domainAndPort.length > 1 ? Integer.parseInt(domainAndPort[1]) : 80;
        String path = parts.length > 1 ? parts[1].substring(parts[1].indexOf("/")) : "/";

        return String.format("%s://%s:%d%s", protocol, domain, port, path);
    }*/



        public static String normalize(String string) {
            String protocol = "http";
            String domain = "localhost";
            int port = 80;
            String path = "/";

            if (string == null || string.isEmpty()) {
                return protocol + "://" + domain + ":" + port + path;
            }

            String[] parts = string.split("://");
            if (parts.length == 1) {
                parts = new String[] { protocol, parts[0] };
            } else if (parts.length != 2) {
                throw new IllegalArgumentException("Invalid string: " + string);
            }

            String[] parts2 = parts[1].split("/", 2);
            if (parts2.length == 2) {
                parts[1] = parts2[0];
                path = "/" + parts2[1];
            }

            String[] parts3 = parts[1].split(":", 2);
            if (parts3.length == 2) {
                parts[1] = parts3[0];
                try {
                    port = Integer.parseInt(parts3[1]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid port: " + parts3[1], e);
                }
            }

            return parts[0] + "://" + parts[1] + ":" + port + path;
        }
    }
