package com.isanechek.beardycastjsonparser.parser;

import com.isanechek.beardycastjsonparser.models.CommentModel;
import com.isanechek.beardycastjsonparser.models.PostModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.isanechek.beardycastjsonparser.Utils.convertDate;

/**
 * Created by isanechek on 23.10.16.
 */
public class ReadJsonFile {

    public static ArrayList<PostModel> readFile(String filePath) {
        ArrayList<PostModel> listPost = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object o = parser.parse(new FileReader(filePath));
            JSONObject object = (JSONObject) o;

//            String s = (String) object.get("forum");
//            System.out.print("forum: " + s);
//
//            JSONArray array = (JSONArray) object.get("categories");
//            Iterator<JSONObject> list = array.iterator();
//            while (list.hasNext()) {
//                System.out.println("categories: " + list.next().get("title").toString());
//            }


            listPost.clear();
            JSONObject threads = (JSONObject) object.get("threads");
            JSONArray comments = (JSONArray) threads.get("/comments");
            for (Object comment : comments) {
                JSONObject jsonObject = (JSONObject) comment;
                JSONObject post = (JSONObject) jsonObject.get("seed");
                String link = (String) post.get("key");
                String title = (String) post.get("title");
//                long date = (long) post.get("date");  // Не нужна

                PostModel model = new PostModel();
                model.setTitle(title);
                model.setUrl(link);

                ArrayList<CommentModel> commentModels = new ArrayList<>();
                commentModels.clear();
                JSONArray replies = (JSONArray) jsonObject.get("replies");
                for (Object repliesObj : replies) {
                    JSONObject replay = (JSONObject) repliesObj;
                    String commentKey = (String) replay.get("key");
                    String commentBody = (String) replay.get("body");
                    long commentDate = (long) replay.get("date");

                    JSONObject authorInfo = (JSONObject) replay.get("author");
                    String nickname = (String) authorInfo.get("path");
                    String fullname = (String) authorInfo.get("displayname");
                    String imgUrl = (String) authorInfo.get("img");

                    CommentModel commentModel = new CommentModel();
                    commentModel.setId(commentKey);
                    commentModel.setText(commentBody);
                    commentModel.setNick(fullname);

                    commentModel.setTime(convertDate(commentDate));
                    commentModel.setAvatar(imgUrl);
                    commentModels.add(commentModel);
                }
                model.setList(commentModels);
                listPost.add(model);
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return listPost;
    }
}
