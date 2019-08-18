package mylistener.listeningmechanism.listenerdemo1;

public class PersonSource {

    private PersonListener personListener;
    public void registerListener(PersonListener personListener){
        this.personListener = personListener;
    }

    public void run(){
        if(personListener!=null){
            Person person = new Person(this);
            personListener.dorun(person);
        }
        System.out.println("走路走路走路");
    }

    public void eat(){
        if(personListener!=null){
            Person person = new Person(this);
            personListener.doeat(person);
        }
        System.out.println("吃。吃。吃。");
    }
}
