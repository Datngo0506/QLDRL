/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Dat
 */
public class Link {
    public static void openLink(String link){
        try {
            // Địa chỉ URL của trang web bạn muốn mở
            URI uri = new URI(link);
            
            // Mở trang web trong trình duyệt mặc định của hệ thống
            Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException | IOException e) {
            //e.printStackTrace();
        }
    }
}
