/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icons;

/**
 *
 * @author Dat
 */
public class Icon {
    public static String getUrlIcon(String s){
        // Lấy đối tượng Class của lớp Main
        Class<?> cls = Icon.class;

        // Sử dụng getProtectionDomain().getCodeSource().getLocation() để lấy URL của thư mục chứa file .class
        
        String classLocation = cls.getProtectionDomain().getCodeSource().getLocation().toString();
        classLocation = classLocation.replace("file:/", "");
        classLocation = classLocation.replace("/target/classes", "");
        return classLocation + "src/main/java/icons/" + s;
    }
}
