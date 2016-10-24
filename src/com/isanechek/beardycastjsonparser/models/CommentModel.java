package com.isanechek.beardycastjsonparser.models;

/**
 * Created by isanechek on 23.10.16.
 */
public class CommentModel {

    /**
     * id - id комментария. Строка 18 символов.
     */
    private String id;

    /**
     * parent_id - id родительского комментария. Строка 18 символов.
     * *Не является обязательный.*
     */
    private String parent_id;

    /**
     * root_id - id комментария корня ветки. Строка 18 символов.
     */
    private String root_id;

    /**
     * text - Текст комментария.
     */
    public String text;

    /**
     * nick - Ник автора комментария. Строка 100 символов.
     */
    private String nick;

    /**
     * time - Время отправки комментария в формате RFC 1123.
     */
    public String time;

    /**
     * ip - ip комментатора. Строка 50 символов.
     */
    private String ip;

    /**
     * email - email комментатора. Строка 100 символов.
     * *Не является обязательный.*
     */
    private String email;

    /**
     * account_id - id комментатора.
     * *Не является обязательный.*
     */
    private int account_id;

    /**
     * files - JSON строка с медиа вложениями.
     * *Не является обязательный.*
     */
    private String files;

    /**
     * vote_up - Голоса за комментарий.
     * *Не является обязательный.*
     */
    private int vote_up;

    /**
     * vote_dn - Голоса против комментария.
     * *Не является обязательный.*
     */
    private int vote_dn;

    /**
     * topic - Является ли комментарий выделенным текстом.
     * *Не является обязательный.*
     */
    private boolean topic;

    /**
     * param - Параметры для гиперкомментариев.
     * *Не является обязательный.*
     */
    private String param;

    /**
     * hc_comment - Является ли комментарий гиперкомментарием.
     * *Не является обязательный.*
     */
    private boolean hc_comment;

    /**
     * avatar - url аватарки пользователя.
     * *Не является обязательный.*
     */
    private String avatar;

    /**
     * category - id категории комментария в системе HC.
     * *Не является обязательный.*
     */
    private int category;

    public CommentModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getRoot_id() {
        return root_id;
    }

    public void setRoot_id(String root_id) {
        this.root_id = root_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public int getVote_up() {
        return vote_up;
    }

    public void setVote_up(int vote_up) {
        this.vote_up = vote_up;
    }

    public int getVote_dn() {
        return vote_dn;
    }

    public void setVote_dn(int vote_dn) {
        this.vote_dn = vote_dn;
    }

    public boolean isTopic() {
        return topic;
    }

    public void setTopic(boolean topic) {
        this.topic = topic;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHc_comment() {
        return hc_comment;
    }

    public void setHc_comment(boolean hc_comment) {
        this.hc_comment = hc_comment;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
