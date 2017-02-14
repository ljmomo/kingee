package com.junly.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

public class ReflectUtil
{
  public static Object getFieldValue(Object obj, String fieldName)
  {
    Object result = null;
    Field field = getField(obj, fieldName);
    if (field != null)
    {
      field.setAccessible(true);
      try
      {
        result = field.get(obj);
      }
      catch (IllegalArgumentException e)
      {
        e.printStackTrace();
      }
      catch (IllegalAccessException e)
      {
        e.printStackTrace();
      }
    }
    return result;
  }
  
  private static Field getField(Object obj, String fieldName)
  {
    Field field = null;
    for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
          .getSuperclass()) {
      try
      {
        field = clazz.getDeclaredField(fieldName);
      }
      catch (NoSuchFieldException localNoSuchFieldException) {}
    }
    return field;
  }
  
  public static void setFieldValue(Object obj, String fieldName, String fieldValue)
  {
    Field field = getField(obj, fieldName);
    if (field != null) {
      try
      {
        field.setAccessible(true);
        field.set(obj, fieldValue);
      }
      catch (IllegalArgumentException e)
      {
        e.printStackTrace();
      }
      catch (IllegalAccessException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void copyPorperties(Object dest, Object source)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Class srcCla = source.getClass();
    Field[] fsF = srcCla.getDeclaredFields();
    Field[] arrayOfField1;
    int j = (arrayOfField1 = fsF).length;
    for (int i = 0; i < j; i++)
    {
      Field s = arrayOfField1[i];
      
      String name = s.getName();
      Object srcObj = invokeGetterMethod(source, name);
      try
      {
        BeanUtils.setProperty(dest, name, srcObj);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static Object invokeGetterMethod(Object target, String propertyName)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    String getterMethodName = "get" + StringUtils.capitalize(propertyName);
    return invokeMethod(target, getterMethodName, new Class[0], 
      new Object[0]);
  }
  
  public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Method method = getDeclaredMethod(object, methodName, parameterTypes);
    if (method == null) {
      throw new IllegalArgumentException("Could not find method [" + 
        methodName + "] parameterType " + parameterTypes + 
        " on target [" + object + "]");
    }
    method.setAccessible(true);
    return method.invoke(object, parameters);
  }
  
  protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes)
  {
    Assert.notNull(object, "object��������");
    for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
          .getSuperclass()) {
      try
      {
        return superClass.getDeclaredMethod(methodName, parameterTypes);
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    return null;
  }
}
