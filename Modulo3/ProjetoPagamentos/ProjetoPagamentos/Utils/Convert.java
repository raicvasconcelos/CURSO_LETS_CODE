package ProjetoPagamentos.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

@SuppressWarnings("rawtypes")
public class Convert {

    
    private static int nivel = 0;
    private static String ident = "";

    private static String getIdent(int n) {
        nivel = n;
        String ident = "";
        for (int i = 0; i < nivel; i++) {
            ident += "  ";
        }
        return ident;
    }

    
    private static Method getGetterMethod(Class c, Field f) {
        for (Method method : c.getDeclaredMethods()) {
            if (method.getName().equalsIgnoreCase("get" + f.getName()))
                return method;
        }
        return null;
    }

    public static <T> void ConvertField(T o, Class objectClass, Field field, StringBuilder sb)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        String nome, valor;

        nome = field.getName();

        Method getterMethod = getGetterMethod(objectClass, field);

        if (getterMethod == null) {
            valor = "Não existe um getter";
        } else {
            Object obj = getterMethod.invoke(o);
            if (obj == null) {
                valor = null;
            } else {
                valor = (obj != null ? obj.toString() : null);
                if (valor.indexOf("@") >= 0) {
                    // Se for um objeto
                    Boolean isIterable = Collection.class.isAssignableFrom(obj.getClass());
                    if (!isIterable) {
                        // Se o objeto não for uma Collection
                        sb.append(toString(obj));
                        sb.append(System.lineSeparator());

                    } else {
                        // Se o objeto for uma Collection
                        sb.append(ident)
                                .append(nome)
                                .append(" : {")
                                .append(System.lineSeparator());

                        nivel++;
                        ident = getIdent(nivel);

                        for (Object item : (Collection) obj) {
                            toString(item);
                            sb.append(",\n");

                        }
                        nivel--;
                        ident = getIdent(nivel);

                        sb.append(ident)
                                .append("}")
                                .append(System.lineSeparator());
                    }
                } else {
                    sb.append(ident)
                            .append(nome)
                            .append(" : ")
                            .append(valor)
                            .append(",")
                            .append(System.lineSeparator());
                }
            }
        }

    }

    public static <T> String toString(T o){
        StringBuilder sb2 = new StringBuilder();
        convertToString(o,  sb2);
        return sb2.toString();
    }
    

    public static <T> String convertToString(T o, StringBuilder sb) {

        try {

            String objectName = o.getClass().getSimpleName();
            Class objectClass = o.getClass();
            Class objectSuperClass = o.getClass().getSuperclass();
            ident = getIdent(nivel);

            sb.append(ident).append(objectName).append(" : ").append("{").append(System.lineSeparator());

            nivel++;
            ident = getIdent(nivel);

            for (Field field : o.getClass().getSuperclass().getDeclaredFields()) {
                ConvertField(o, objectSuperClass, field, sb);
            }
            for (Field field : o.getClass().getDeclaredFields()) {
                ConvertField(o, objectClass, field, sb);
            }

            nivel--;
            ident = getIdent(nivel);

            sb.append(ident).append("}");

            return sb.toString();

        }

        catch (Exception e) {
            return ">>> ERRO: " + e.getMessage();
        }
    }

}
