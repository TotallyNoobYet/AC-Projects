class StringManipulation {
    public static void main(String[] args) {
        String str = "http://www.academiadecodigo.org";

        String domain = ""; // www.academiadecodigo.org
        String name = "";   // < Academia de Codigo_ >

        domain  = str.replace("http://", "");
        System.out.println(domain);

        String subStrName = str.substring(str.indexOf("a"), str.lastIndexOf("o") - 1);

        String academia = subStrName.substring(subStrName.indexOf("a"), subStrName.lastIndexOf("a") + 1);
        String academiaCaps = academia.substring(0, 1).toUpperCase() + academia.substring(1);

        String de = subStrName.substring(subStrName.indexOf("d", 8), subStrName.indexOf("e") + 6);

        String codigo = subStrName.substring(subStrName.lastIndexOf("c"), subStrName.lastIndexOf("o") + 1);
        String codigoCaps = codigo.substring(0, 1).toUpperCase() + codigo.substring(1);

        name = "< " + academiaCaps + " " + de + " " + codigoCaps + "_>";
        System.out.println(name);

    }
}