package zuper.programmer.test;

public class Calculator {
    public Integer devide(Integer first, Integer second)
    {
        if(second == 0) {
            throw new IllegalArgumentException("tidak bisa membagi dengan 0");
        }
        return first / second;
    }

    public Integer add(Integer first, Integer second)
    {
        return first + second;
    }

}
