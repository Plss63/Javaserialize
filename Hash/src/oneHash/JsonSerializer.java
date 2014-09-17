package oneHash;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class JsonSerializer {

    public void serialize(Object object, OutputStream output) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException {
        Class<?> c = object.getClass();

        PrintWriter pw = new PrintWriter(output);
        StringBuilder json = new StringBuilder();
        json.append("{");
        Set<Class<?>> type = new HashSet<Class<?>>();
        type.add(String.class);
        type.add(int.class);
        type.add(long.class);
        type.add(Integer.class);
        type.add(Long.class);
        type.add(Float.class);
        type.add(Double.class);
        type.add(float.class);
        type.add(double.class);
        boolean flag = false;
        while (c != Object.class) {
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields) {
                Class<?> fieldType = field.getType();
                field.setAccessible(true);
                if (type.contains(fieldType)) {
                    if (flag)
                        json.append(',');
                    json.append('"');
                    json.append(field.getName());
                    json.append('"');
                    json.append(" : ");
                    json.append('"');
                    json.append(field.get(object));
                    json.append('"');
                    flag = true;
                }

            }
            c = c.getSuperclass();
        }
        json.append("}");
        pw.println(json.toString());
        pw.flush();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException,
            IllegalAccessException {
        // Class<?> my2 = Class.forName("oneHash.MyHash");
        MyHash my = new MyHash();
        JsonSerializer js = new JsonSerializer();
        OutputStream output = System.out;
        js.serialize(my, output);
        // System.out.println(my2.equals(my.getClass()));
        // System.out.println(my2.equals(MyHash.class));

    }

}
