package mylistener.listeningmechanism.listenerdemo1;

public class Person {

    private PersonSource personSource;
    public Person(){}

    public Person(PersonSource personSource){
        this.personSource = personSource;
    }

    public PersonSource getPersonSource() {
        return personSource;
    }

    public void setPersonSource(PersonSource personSource) {
        this.personSource = personSource;
    }
}
