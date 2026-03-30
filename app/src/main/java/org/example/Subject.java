package org.example;

 class Subject{
    private String Name;
    private int Hours;


    public Subject(String name, int hours) {
        setName(name);
        setHours(hours);
    }

    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }

     public int getHours(){
        return this.Hours;
    }
     public void setHours(int hours){
        this.Hours = hours;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return 
        java.util.Objects.equals(Name,subject.getName())&&
         java.util.Objects.equals(Hours,subject.getHours());
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(Name, Hours);
    }
        }

