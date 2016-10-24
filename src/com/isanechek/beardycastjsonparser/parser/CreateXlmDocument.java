package com.isanechek.beardycastjsonparser.parser;

import com.isanechek.beardycastjsonparser.models.CommentModel;
import com.isanechek.beardycastjsonparser.models.PostModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by isanechek on 23.10.16.
 */
public class CreateXlmDocument {

    public static boolean createXmlDocument(String pathToSaveFile, ArrayList<PostModel> models) {

        Document doc = null;
        try {
            for (PostModel model : models) {
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();

                // root element
                 doc = builder.newDocument();
                Element rootElement = doc.createElement("hc");
                doc.appendChild(rootElement);

                // post element
                Element post = doc.createElement("post");
                rootElement.appendChild(post);

                // title post
                Element titleElement = doc.createElement("title");
                titleElement.appendChild(doc.createTextNode(model.getTitle()));
                post.appendChild(titleElement);

                // url on post
                Element postUrlElement = doc.createElement("url");
                postUrlElement.appendChild(doc.createTextNode(model.getUrl()));
                post.appendChild(postUrlElement);

                Element xidElement = doc.createElement("xid");
                xidElement.appendChild(doc.createTextNode("XID"));
                post.appendChild(xidElement);

                Element streamIdElement = doc.createElement("stream_id");
                streamIdElement.appendChild(doc.createTextNode("STREAM_ID"));
                post.appendChild(streamIdElement);

                Element elementComments = doc.createElement("comments");
                post.appendChild(elementComments);

                for (int i = 0; i < model.getList().size(); i++) {
                    CommentModel comment = model.getList().get(i);
                    Element commentElement = doc.createElement("comment");
                    elementComments.appendChild(commentElement);

                    Element idCommentElement = doc.createElement("id");
                    idCommentElement.appendChild(doc.createTextNode(comment.getId()));
                    commentElement.appendChild(idCommentElement);

                    Element parentIdCommentElement = doc.createElement("parent_id");
                    commentElement.appendChild(parentIdCommentElement);

                    Element rootIdCommentElement = doc.createElement("root_id");
                    commentElement.appendChild(rootIdCommentElement);

                    Element textCommentElement = doc.createElement("text");
                    textCommentElement.appendChild(doc.createTextNode(comment.getText()));
                    commentElement.appendChild(textCommentElement);

                    Element nickCommentElement = doc.createElement("nick");
                    nickCommentElement.appendChild(doc.createTextNode(comment.getNick()));
                    commentElement.appendChild(nickCommentElement);

                    Element timeCommentElement = doc.createElement("time");
                    timeCommentElement.appendChild(doc.createTextNode("tttt"));
                    commentElement.appendChild(timeCommentElement);

                    Element ipCommentElement = doc.createElement("ip");
                    commentElement.appendChild(ipCommentElement);

                    Element emailCommentElement = doc.createElement("email");
                    commentElement.appendChild(emailCommentElement);

                    Element accountIdCommentElement = doc.createElement("account_id");
                    commentElement.appendChild(accountIdCommentElement);

                    Element filesCommentElement = doc.createElement("files");
                    commentElement.appendChild(filesCommentElement);

                    Element voteUpCommentElement = doc.createElement("vote_up");
                    voteUpCommentElement.appendChild(doc.createTextNode("0"));
                    commentElement.appendChild(voteUpCommentElement);

                    Element voteDnCommentElement = doc.createElement("vote_dn");
                    voteDnCommentElement.appendChild(doc.createTextNode("0"));
                    commentElement.appendChild(voteDnCommentElement);

                    Element topicCommentElement = doc.createElement("topic");
                    topicCommentElement.appendChild(doc.createTextNode("false"));
                    commentElement.appendChild(topicCommentElement);

                    Element paramCommentElement = doc.createElement("param");
                    commentElement.appendChild(paramCommentElement);

                    Element hcCommentElement = doc.createElement("hc_comment");
                    hcCommentElement.appendChild(doc.createTextNode("false"));
                    commentElement.appendChild(hcCommentElement);

                    Element avatarCommentElement = doc.createElement("avatar");
                    avatarCommentElement.appendChild(doc.createTextNode(comment.getAvatar()));
                    commentElement.appendChild(avatarCommentElement);

                    Element categoryCommentElement = doc.createElement("category");
                    categoryCommentElement.appendChild(doc.createTextNode("2"));
                    commentElement.appendChild(categoryCommentElement);

                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(new File(pathToSaveFile + "/Comments.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("Done");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
