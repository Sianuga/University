public class Debugger
{
    public static void fields(Object obj) throws IllegalAccessException
    {
        var fields = obj.getClass().getDeclaredFields();
        for(var field:fields)
        {
            field.setAccessible(true);
            System.out.println("Pole:" + field.getName() +"=>"+field.getType().getSimpleName()+ ", " + field.get(obj));
        }
    }
}
