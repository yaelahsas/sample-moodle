package com.example.moodle.model;

/**
 * Created by Dhimas Panji Sastra on
 * Copyright (c)  . All rights reserved.
 * Last modified $file.lastModified
 * Made With ❤ for U
 */
public class ModelQuizByCourse {
    public int id;
    public int course;
    public int coursemodule;
    public String name;
    public String intro;
    public int introformat;
    //    public List<Object> introfiles = null;
    public int timeopen;
    public int timeclose;
    public int timelimit;
    public String preferredbehaviour;
    public int attempts;
    public int grademethod;
    public int decimalpoints;
    public int questiondecimalpoints;
    public int sumgrades;
    public int grade;
    public int hasfeedback;
    public int section;
    public int visible;
    public int groupmode;
    public int groupingid;

    public ModelQuizByCourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCoursemodule() {
        return coursemodule;
    }

    public void setCoursemodule(int coursemodule) {
        this.coursemodule = coursemodule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getIntroformat() {
        return introformat;
    }

    public void setIntroformat(int introformat) {
        this.introformat = introformat;
    }

    public int getTimeopen() {
        return timeopen;
    }

    public void setTimeopen(int timeopen) {
        this.timeopen = timeopen;
    }

    public int getTimeclose() {
        return timeclose;
    }

    public void setTimeclose(int timeclose) {
        this.timeclose = timeclose;
    }

    public int getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(int timelimit) {
        this.timelimit = timelimit;
    }

    public String getPreferredbehaviour() {
        return preferredbehaviour;
    }

    public void setPreferredbehaviour(String preferredbehaviour) {
        this.preferredbehaviour = preferredbehaviour;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getGrademethod() {
        return grademethod;
    }

    public void setGrademethod(int grademethod) {
        this.grademethod = grademethod;
    }

    public int getDecimalpoints() {
        return decimalpoints;
    }

    public void setDecimalpoints(int decimalpoints) {
        this.decimalpoints = decimalpoints;
    }

    public int getQuestiondecimalpoints() {
        return questiondecimalpoints;
    }

    public void setQuestiondecimalpoints(int questiondecimalpoints) {
        this.questiondecimalpoints = questiondecimalpoints;
    }

    public int getSumgrades() {
        return sumgrades;
    }

    public void setSumgrades(int sumgrades) {
        this.sumgrades = sumgrades;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getHasfeedback() {
        return hasfeedback;
    }

    public void setHasfeedback(int hasfeedback) {
        this.hasfeedback = hasfeedback;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getGroupmode() {
        return groupmode;
    }

    public void setGroupmode(int groupmode) {
        this.groupmode = groupmode;
    }

    public int getGroupingid() {
        return groupingid;
    }

    public void setGroupingid(int groupingid) {
        this.groupingid = groupingid;
    }
}
