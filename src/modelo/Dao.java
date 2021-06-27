
package modelo;


public abstract class Dao<T extends Dto>
{

    protected void Dto(){}

    public String insert(Dto data)
    {
        return data.insert();
    }


}
