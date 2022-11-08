class date(){
    int day;
    int month;
    int year;
    boolean isSameYear(Date another){
        return this.year==another.Getyear();
    }
//ahora con if
    boolean isSameYear(Date another){
        if (this.year==another.getYear()){
            return true;
        }else{
            return false;
        }
    }
    string getMonthName(){
        switch(this.month){
            case 1:
                monthName="Enero";
                break;
            case 2:
                monthName="Febrero";
                break;
            //todos los casos
            return monthName;
        }
    }
    private int getNumDaysMonth(int month){}
    int getNumDaysSinceStart(){
    int i, numDays=this.day;
    for(i=this.month -1,i>=1,i--){
        numDays=getNumDaysMonth(i);
    }
    return numDays;    
    }
    Date getRandomDate();
    int getNumAttemptsToDay(){
        int numTries=0;
        Date date;
        do{
            date=getRandomDate();
            numTries++;

        }while(!date.equals(this));//!this.equals(date)
        return numTries;
    }
}
