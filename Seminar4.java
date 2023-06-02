public class Seminar4 {
    public static void main(String[] args) {
        Mapa<String, String> mapa = new Mapa<>();
        
        mapa.put("10", "100");
        mapa.put("11", "110");
        mapa.put("12", "120");
        mapa.put("13", "130");
        mapa.put("14", "140");
        mapa.put("15", "150");
        mapa.put("16", "160");
        mapa.put("17", "170");
        // mapa.replace("11", "ssssssssss");
        
        // System.out.println(mapa.getIndex("13"));                
        // System.out.println(mapa.get("13"));
        // System.out.println(mapa.sizeHash());
        // System.out.println(mapa.containsKey("12"));
        System.out.println(mapa.containsValue("110"));
        // System.out.println(mapa.containsValue2("110"));
        
        
        // for (int i = 0; i < 5; i++) {
        //     mapa.put(Integer.toString(i + 10), Integer.toString(i));
        // }
        // // System.out.println(mapa.get("11"));
        // System.out.println(mapa.remove("14"));
    }
}