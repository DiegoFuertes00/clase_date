class MainDate{
    public static void main (String args[]){
        Date hoy=new Date(26,10,2022);
        Date ayer=new Date(25,10,2022);
        So.p.(hoy.isSameYear(ayer));
        hoy.getNumDaysSinceStart();
        
    }
}