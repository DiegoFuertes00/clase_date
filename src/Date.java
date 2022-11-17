
/* @author DIEGO FUERTES LOPEZ 
dfuerl00@estudiantes.unileon.es 
usuario <github>->DiegoFuertes00 */




package es.unileon.prg1.date;

public class Date{
    private int day;
    private int month;
    private int year;
//creo metodos para asignar variables
    public Date(int day, int month, int year) throws DateException{
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }


    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public void setDay(int day) throws DateException{
        if (day<1 || day>this.getNumDaysMonth()){
            throw new DateException("Date error: Day "+ day+" of month "+this.month+" not valid");
        }
        this.day=day;

    }
    public void setMonth(int month) throws DateException{
        if (month<1 || month>12){
            throw DateException("Date error: Month "+month+" not valid");
        }
        this.month=month;
    }
    
    public void setYear(int year){
        this.year=year;
    }


//empezamos los metodos pedidos de la clase date


/* Including the if statement develop:
    • The isSameYear method
    • The isSameMonth method
    • The isSameDay method
    • The isSame method */


    public boolean isSameYear(Date another){
        if (this.year==another.getYear())
            return true;
        else
            return false;
    }
    public boolean isSameMonth(Date another){
        if (this.month==another.getMonth())
            return true;
        else
            return false;
    }
    public boolean isSameDay(Date another){
        if(this.day==another.getMonth())
            return true;
        else
            return false;
    }
    public boolean isSame(){
        if((isSameMonth(month)==true)&&(isSameYear(year)==true)&&(isSameDay(day)==true))
            return true;
        else
            return false;
    }



/* Include in Date class:
    • A method that returns the name of the month
    • A method that checks if the day of the month is right
    • A method that returns the season of this month
    • IMPORTANT: Pay special attention to the names
    you give to those methods */


    public String getMonthName(int month){
        String monthName;
        switch(this.month){
            case 1:
                monthName="Enero";
                break;
            case 2:
                monthName="Febrero";
                break;
            case 3:
                monthName="Marzo";
                break;
            case 4:
                monthName="Abril";
                break;
            case 5:
                monthName="Mayo";
                break;
            case 6:
                monthName="Junio";
                break;
            case 7:
                monthName="Julio";
                break;
            case 8:
                monthName="Agosto";
                break;
            case 9:
                monthName="Septiembre";
                break;
            case 10:
                monthName="Octubre";
                break;
            case 11:
                monthName="Noviembre";
                break;
            case 12:
                monthName="Diciembre";
                break;
            default:
                monthName="error";
                break;                
        }
        return monthName;
    }


    public boolean correctDay(int day, int month, int year) {
		if((this.month==1)||(this.month==3)||(this.month==5)||(this.month==7)||(this.month==8)||(this.month==10)||(this.month==12)){
			if((this.day>0)&&(this.day<=31)){
				return true;
            }
        }else if((this.month==4)||(this.month==6)||(this.month==9)||(this.month==11)){
			    if(day>0 && day<=30) {
				    return true;
				}	
		}else if(this.month==2){
            //excepciones de anios bisiestos.Un anio es bisiesto si es divisble por 4 y no por 100, o si es divisible por 400.
			if((year%4==0)&&((year%100!=0))||(year%400==0)){
				if(day>0 && day<=29) {
				    return true;
				}
	        }else{
				if(day>0 && day<=28){
					return true;
				}
			}
        }else{
		return false;
        }	
	}
    
    
    public String getSeason(int day, int month){
        String season="";
        boolean correctDay=correctDay();
        if(correctDay(this.day,this.month,this.year)==true){
            if(((this.day>=21)&&(this.month>=3))&&((this.day<21)&&(this.month<=6))){

            
                season="Primavera";
            }if else(((this.day>=21)&&(this.month>=6))&&((this.day<23)&&(this.month<=9))){
                season="Verano";
            }if else(((this.day>=23)&&(this.month>=9))&&((this.day<21)&&(this.month<=12))){
                season="Otoño";
            }else{
                season="Invierno";
           }
        }
        return season;
     }


/* In the Date class write methods to:
    • For a date, return the months left until the end of the
    year.
    • Write a method in Date class that returns the string
    version a date.
    • For a date, returns all dates until the end of the month.
    • For a date, returns the months with the same number
    of days as the month of this date.
    • For a date, count the number of days since the first day
    of the year (do not consider leap years)
 */
    public int monthsTillNextYear(int month){
        int monthsTillNextYear=12-this.month;
        return monthsTillNextYear;
    }


    public String dateToString(int day, int month, int year){
        StringBuilder dateToString=new StringBuilder();
        dateToString.append(this.day+"/"+this.month+"/"+this.year);
        return dateToString.toString();
    }


    public int datesTillNextMonth(int day, int month){
        int datesTillNextMonth=0;
        boolean correctDay=correctDay();
        if((this.month==1)||(this.month==3)||(this.month==5)||(this.month==7)||(this.month==8)||(this.month==10)||(this.month==12)){
            datesTillNextMonth=31-this.day;
        }else if((this.month==4)||(this.month==6)||(this.month==9)||(this.month==11)){
			datesTillNextMonth=30-this.day;
		}else{
            //excepciones de anios bisiestos.
			if((year%4==0)&&((year%100!=0))||(year%400==0)){
				datesTillNextMonth=29-this.day;
	        }else{
				datesTillNextMonth=28-this.day;
			 }
        }   
        
        return datesTillNextMonth;
    }


    public void monthsSameDays(int month){
        if ((this.month==1)||(this.month==3)||(this.month==5)||(this.month==7)||(this.month==8)||(this.month==10)||(this.month==12))
            System.out.println("Los meses con los mismos dias que "+this.month+" son Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre");
        else if((this.month==4)||(this.month==6)||(this.month==9)||(this.month==11))
            System.out.println("los meses con los mismo días que "+this.month+" son Febrero, Abril, Junio, Septiembre y Noviembre");
        else
            System.out.println("No hya ningun mes con los mismos dias que "+this.month);
    }

    //sin considerar anios bisiestos
    //creo un metodo a mayores para que me devuelva cuantos días tiene cada mes
    private int getNumDaysMonth(int month){
        int getNumDaysMonth=0;
        if ((this.month==1)||(this.month==3)||(this.month==5)||(this.month==7)||(this.month==8)||(this.month==10)||(this.month==12))
            getNumDaysMonth=31;
        else if((this.month==4)||(this.month==6)||(this.month==9)||(this.month==11))
            getNumDaysMonth=30;
        else
            getNumDaysMonth=28;

        return getNumDaysMonth;
    }

    int getNumDaysSinceStart(){
        int i, numDays=this.day;
        for(i=this.month-1;i>=1;i--){
            numDays=numDays+getNumDaysMonth(i);
        }
        return numDays;    
    }

/* In the Date class build the following methods:
    • Build a method that counts the number of attempts
    needed to generate a random date equals to a given
    date (only inside the same year)
    • Do it using a while statement
    • Do it using a do-while statement
    • For a given date and knowing the day of the week of
    the first day of the year of that date, return the day of
    the week of the given date. */


    public int getNumAttemptsToDayConWhile(){
        int numTries=0;
        int dia=0;
        int mes=0;
        while((this.day!=dia)&&(this.month!=mes)){
            dia=(int)((Math.random()*31)+1);
            mes=(int)((Math.random()*12)+1);
            numTries++;

        }
        return numTries;
    }
    public int getNumAttemptsToDayConDoWhile(){
        int numTries=0;
        Date date;
        do{
            dia=(int)((Math.random()*31)+1);
            mes=(int)((Math.random()*12)+1);
            numTries++;

        }while((this.day!=dia)&&(this.month!=mes));
        return numTries;
    }
    public String dayOfTheWeek(int day, int month, int year){
        String dayOfTheWeek;
        //vamos a suponer que el primer dia del anio es lunes;
        String firstDayOfTheYear=new String ("Lunes");
        int resto=(getNumDaysSinceStart(this.day))%7;
        switch(resto){
            case 1:
                dayOfTheWeek="Lunes";
                break;
            case 2:
                dayOfTheWeek="Martes";
                break;
            case 3:
                dayOfTheWeek="Miercoles";
                break;
            case 4:
                dayOfTheWeek="Jueves";
                break;
            case 5:
                dayOfTheWeek="Viernes";
                break;
            case 6:
                dayOfTheWeek="Sabado";
                break;
            case 0:
                dayOfTheWeek="Domingo";
                break;
            default:
                dayOfTheWeek="error";
                break;
        }

        return dayOfTheWeek;
    }

}
