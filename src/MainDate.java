 public class MainDate{
    public static void main (String args[]){
        Date today;
        try{
            today= new Date (16,11,2022);
            System.out.println(today);
            System.out.println(today.isSameYear());
            
        } catch (DateException e){
            System.out.println(e.getMessage());
        }
    }
}