package group144.khodand;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

/** Get code of class. */
public class Code {
    /**
     * Get class specification.
     *
     * @return  Result of scanning
     * */
    public String describeClass(Class clazz) {
        StringBuilder builder = new StringBuilder();

        getClassSpecification(builder, clazz, "");

        return builder.toString();
    }


    private void getClassSpecification(StringBuilder builder, Class clazz, String tab) {
        boolean indent = false;

        builder.append(tab);
        getClassSignature(builder, clazz);
        builder.append("{\n");

        Field[] fields = clazz.getDeclaredFields();
        Arrays.sort(fields,  new Comparator<Field>() {
            public int compare(Field first, Field second) {
                return first.getName().compareTo(second.getName());
            }
        });
        for (int i = 0; i < fields.length; i++) {
            if (!isNumber(fields[i].getName().replace("this$", ""))) {
                builder.append(tab);
                builder.append("    ");
                getFieldSignature(builder, clazz, fields[i]);
                builder.append("\n");
                indent = true;
            }
        }

        Constructor[] constructors = clazz.getDeclaredConstructors();
        Arrays.sort(constructors,  new Comparator<Constructor>() {
            public int compare(Constructor first, Constructor second) {
                return first.getName().compareTo(second.getName());
            }
        });
        checkBlock(builder, indent, constructors.length);
        for (int i = 0; i < constructors.length; i++) {
            builder.append(tab);
            builder.append("    ");
            getConstructorSignature(builder, clazz, constructors[i]);
            builder.append("\n");
            indent = true;
        }

        Method[] methods = clazz.getDeclaredMethods();
        Arrays.sort(methods,  new Comparator<Method>() {
            public int compare(Method first, Method second) {
                return first.getName().compareTo(second.getName());
            }
        });
        checkBlock(builder, indent, methods.length);
        for (int i = 0; i < methods.length; i++) {
            builder.append(tab);
            builder.append("    ");
            getMethodSignature(builder, clazz, methods[i]);
            builder.append("\n");
            indent = true;
        }

        Class[] classes = clazz.getDeclaredClasses();
        Arrays.sort(classes,  new Comparator<Class>() {
            public int compare(Class first, Class second) {
                return first.getName().compareTo(second.getName());
            }
        });
        checkBlock(builder, indent, classes.length);
        for (int i = 0; i < classes.length; i++) {
            getClassSpecification(builder, classes[i], tab + "    ");
        }

        builder.append(tab);
        builder.append("}\n");
    }

    private void getClassSignature(StringBuilder builder, Class clazz) {
        String modifiers = Modifier.toString(clazz.getModifiers()) + " ";

        if (clazz.isInterface()) {
            builder.append(modifiers.replace("abstract ", ""));
        } else {
            builder.append(modifiers);
            builder.append("class ");
        }

        builder.append(clazz.getSimpleName());
        builder.append(" ");

        if ((clazz.getSuperclass() != null) && !clazz.getSuperclass().equals(Object.class)) {
            builder.append("extends ");
            builder.append(clazz.getSuperclass().getSimpleName());
            builder.append(" ");
        }

        if (clazz.getInterfaces().length != 0) {
            Class[] interfaces = clazz.getInterfaces();
            builder.append("implements ");
            builder.append(interfaces[0].getSimpleName());

            for (int i = 1; i < interfaces.length; i++) {
                builder.append(", ");
                builder.append(interfaces[i].getSimpleName());
            }

            builder.append(" ");
        }
    }

    private void getFieldSignature(StringBuilder builder, Class clazz, Field field) {
        String modifiers = Modifier.toString(field.getModifiers()) + " ";

        if (clazz.isInterface()) {
            builder.append(modifiers.replace("static ", ""));
        } else {
            builder.append(modifiers);
        }

        builder.append(field.getType().getSimpleName());
        builder.append(" ");
        builder.append(field.getName());
        builder.append(";");
    }

    private void getConstructorSignature(StringBuilder builder, Class clazz, Constructor constructor) {
        builder.append(Modifier.toString(constructor.getModifiers()));
        builder.append(" ");
        builder.append(clazz.getSimpleName());
        builder.append("(");
        getParameters(builder, constructor.getParameters());
        builder.append(");");
    }

    private void getMethodSignature(StringBuilder builder, Class clazz, Method method) {
        String modifiers = Modifier.toString(method.getModifiers()) + " ";

        if (clazz.isInterface()) {
            builder.append(modifiers.replace("abstract ", ""));
        } else {
            builder.append(modifiers);
        }

        builder.append(method.getReturnType().getSimpleName());
        builder.append(" ");
        builder.append(method.getName());
        builder.append("(");
        getParameters(builder, method.getParameters());
        builder.append(");");
    }

    private void getParameters(StringBuilder builder, Parameter[] parameters) {
        if (parameters.length == 0) {
            return;
        }

        builder.append(parameters[0].getType().getSimpleName());
        builder.append(" ");
        builder.append(parameters[0].getName());

        for (int i = 1; i < parameters.length; i++) {
            builder.append(", ");
            builder.append(parameters[i].getType().getSimpleName());
            builder.append(" ");
            builder.append(parameters[i].getName());
        }
    }

    private boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void checkBlock(StringBuilder builder, boolean indent, int length) {
        if (indent && (length != 0)) {
            builder.append("\n");
        }
    }
}