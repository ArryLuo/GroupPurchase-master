package com.lagersoft.gp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/** 
 * SharedPrefereces读写工具类
 * @author bear 
 */  
public class SharedPrefsUtil {  
      
	public static final String PREF_NAME = "ecsf_financing";
	public static final String IS_FIRST_RUN = "is_first_run";
	
    /** 
     * ��SharedPreferences��д��int�������� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param value ֵ 
     */  
    public static void putValue(Context context, String name, String key,  
            int value) {  
        Editor sp = getEditor(context, name);  
        sp.putInt(key, value);  
        sp.commit();  
    }  
      
    /** 
     * ��SharedPreferences��д��boolean���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param value ֵ 
     */  
    public static void putValue(Context context, String name, String key,  
            boolean value) {  
        Editor sp = getEditor(context, name);  
        sp.putBoolean(key, value);  
        sp.commit();  
    }  
      
    /** 
     * ��SharedPreferences��д��String���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param value ֵ 
     */  
    public static void putValue(Context context, String name, String key,  
            String value) {  
        Editor sp = getEditor(context, name);  
        sp.putString(key, value);  
        sp.commit();  
    }  
      
    /** 
     * ��SharedPreferences��д��float���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param value ֵ 
     */  
    public static void putValue(Context context, String name, String key,  
            float value) {  
        Editor sp = getEditor(context, name);  
        sp.putFloat(key, value);  
        sp.commit();  
    }  
  
    /** 
     * ��SharedPreferences��д��long���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param value ֵ 
     */  
    public static void putValue(Context context, String name, String key,  
            long value) {  
        Editor sp = getEditor(context, name);  
        sp.putLong(key, value);  
        sp.commit();  
    }  
      
    /** 
     * ��SharedPreferences�ж�ȡint���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param defValue �����ȡ���ɹ���ʹ��Ĭ��ֵ 
     * @return ���ض�ȡ��ֵ 
     */  
    public static int getValue(Context context, String name, String key,  
            int defValue) {  
        SharedPreferences sp = getSharedPreferences(context, name);  
        int value = sp.getInt(key, defValue);  
        return value;  
    }  
      
    /** 
     * ��SharedPreferences�ж�ȡboolean���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param defValue �����ȡ���ɹ���ʹ��Ĭ��ֵ 
     * @return ���ض�ȡ��ֵ 
     */  
    public static boolean getValue(Context context, String name, String key,  
            boolean defValue) {  
        SharedPreferences sp = getSharedPreferences(context, name);  
        boolean value = sp.getBoolean(key, defValue);  
        return value;  
    }  
      
    /** 
     * ��SharedPreferences�ж�ȡString���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param defValue �����ȡ���ɹ���ʹ��Ĭ��ֵ 
     * @return ���ض�ȡ��ֵ 
     */  
    public static String getValue(Context context, String name, String key,  
            String defValue) {  
        SharedPreferences sp = getSharedPreferences(context, name);  
        String value = sp.getString(key, defValue);  
        return value;  
    }  
      
    /** 
     * ��SharedPreferences�ж�ȡfloat���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param defValue �����ȡ���ɹ���ʹ��Ĭ��ֵ 
     * @return ���ض�ȡ��ֵ 
     */  
    public static float getValue(Context context, String name, String key,  
            float defValue) {  
        SharedPreferences sp = getSharedPreferences(context, name);  
        float value = sp.getFloat(key, defValue);  
        return value;  
    }  
      
    /** 
     * ��SharedPreferences�ж�ȡlong���͵����� 
     *  
     * @param context �����Ļ��� 
     * @param name ��Ӧ��xml�ļ����� 
     * @param key �� 
     * @param defValue �����ȡ���ɹ���ʹ��Ĭ��ֵ 
     * @return ���ض�ȡ��ֵ 
     */  
    public static long getValue(Context context, String name, String key,  
            long defValue) {  
        SharedPreferences sp = getSharedPreferences(context, name);  
        long value = sp.getLong(key, defValue);  
        return value;  
    }  
      
    //��ȡEditorʵ��  
    private static Editor getEditor(Context context, String name) {  
        return getSharedPreferences(context, name).edit();  
    }  
  
    //��ȡSharedPreferencesʵ��  
    private static SharedPreferences getSharedPreferences(Context context, String name) {  
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);  
    }  
}