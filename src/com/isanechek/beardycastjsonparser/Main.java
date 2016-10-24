package com.isanechek.beardycastjsonparser;

import com.isanechek.beardycastjsonparser.models.CommentModel;
import com.isanechek.beardycastjsonparser.models.PostModel;
import com.isanechek.beardycastjsonparser.parser.CreateXlmDocument;
import com.isanechek.beardycastjsonparser.parser.ReadJsonFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome");

        String path = "/home/isanechek/Beardycast";
        testWrite(path, path + "/bc");
//        showDialog();

    }

    private static void showDialog() {
        JFrame frame = new JFrame("Parser");
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton openButton = new JButton("Open");
        panel.add(openButton);
        openButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int ret = chooser.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
//                testWrite(file.getAbsolutePath(), file.getPath());
                System.out.println("path test: " + file.getParent());
            }
        });
    }

    private static void testWrite(String out, String path) {


        ArrayList<PostModel> list = ReadJsonFile.readFile(path);
//        Runnable runnable = () -> {
//            boolean status = CreateXlmDocument.createXmlDocument(out, list);
//            if (status) {
//                System.out.println("Create Done");
//            }
//        };
//        runnable.run();
        if (list.size() != 0) {
            System.out.println("list size: " + list.size());

            for (PostModel model : list) {
                System.out.println("Post: " + model.getTitle());
                List<CommentModel> commentModels = model.getList();
                for (CommentModel commentModel : commentModels) {

                    String t = Utils.getNormalString(commentModel.getText());
                    System.out.println("comment: " + t);
                    System.out.println("author: " + commentModel.getNick());
//                System.out.println("comment: " + commentModel.getTime());
                }
            }

        }
    }

    private static final String URL_PATTERN = "(http|https|ftp|ftps|)\\:\\/\\/[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(\\/\\S*)?";

}
