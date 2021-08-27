package com.example.moodle.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dhimas Panji Sastra on
 * Copyright (c)  . All rights reserved.
 * Last modified $file.lastModified
 * Made With ❤ for U
 */
public class ModelUserCourse implements Parcelable {

    public static final Creator<ModelUserCourse> CREATOR = new Creator<ModelUserCourse>() {
        @Override
        public ModelUserCourse createFromParcel(Parcel in) {
            return new ModelUserCourse(in);
        }

        @Override
        public ModelUserCourse[] newArray(int size) {
            return new ModelUserCourse[size];
        }
    };
    public int id;
    public String shortname;
    public String fullname;
    public String displayname;
    public int enrolledusercount;
    public String idnumber;
    public int visible;
    public String summary;
    public int summaryformat;
    public String format;
    public boolean showgrades;
    public String lang;
    public boolean enablecompletion;
    public boolean completionhascriteria;
    public boolean completionusertracked;
    public int category;
    public String progress;
    public boolean completed;
    public int startdate;
    public int enddate;
    public int marker;
    public String lastaccess;
    public boolean isfavourite;
    //    public List<Object> overviewfiles = null;
    public boolean hidden;

    public ModelUserCourse() {
    }

    protected ModelUserCourse(Parcel in) {
        id = in.readInt();
        shortname = in.readString();
        fullname = in.readString();
        displayname = in.readString();
        enrolledusercount = in.readInt();
        idnumber = in.readString();
        visible = in.readInt();
        summary = in.readString();
        summaryformat = in.readInt();
        format = in.readString();
        showgrades = in.readByte() != 0;
        lang = in.readString();
        enablecompletion = in.readByte() != 0;
        completionhascriteria = in.readByte() != 0;
        completionusertracked = in.readByte() != 0;
        category = in.readInt();
        progress = in.readString();
        completed = in.readByte() != 0;
        startdate = in.readInt();
        enddate = in.readInt();
        marker = in.readInt();
        lastaccess = in.readString();
        isfavourite = in.readByte() != 0;
        hidden = in.readByte() != 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public int getEnrolledusercount() {
        return enrolledusercount;
    }

    public void setEnrolledusercount(int enrolledusercount) {
        this.enrolledusercount = enrolledusercount;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(int summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isShowgrades() {
        return showgrades;
    }

    public void setShowgrades(boolean showgrades) {
        this.showgrades = showgrades;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public boolean isCompletionhascriteria() {
        return completionhascriteria;
    }

    public void setCompletionhascriteria(boolean completionhascriteria) {
        this.completionhascriteria = completionhascriteria;
    }

    public boolean isCompletionusertracked() {
        return completionusertracked;
    }

    public void setCompletionusertracked(boolean completionusertracked) {
        this.completionusertracked = completionusertracked;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getStartdate() {
        return startdate;
    }

    public void setStartdate(int startdate) {
        this.startdate = startdate;
    }

    public int getEnddate() {
        return enddate;
    }

    public void setEnddate(int enddate) {
        this.enddate = enddate;
    }

    public int getMarker() {
        return marker;
    }

    public void setMarker(int marker) {
        this.marker = marker;
    }

    public String getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(String lastaccess) {
        this.lastaccess = lastaccess;
    }

    public boolean isIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(boolean isfavourite) {
        this.isfavourite = isfavourite;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(shortname);
        dest.writeString(fullname);
        dest.writeString(displayname);
        dest.writeInt(enrolledusercount);
        dest.writeString(idnumber);
        dest.writeInt(visible);
        dest.writeString(summary);
        dest.writeInt(summaryformat);
        dest.writeString(format);
        dest.writeByte((byte) (showgrades ? 1 : 0));
        dest.writeString(lang);
        dest.writeByte((byte) (enablecompletion ? 1 : 0));
        dest.writeByte((byte) (completionhascriteria ? 1 : 0));
        dest.writeByte((byte) (completionusertracked ? 1 : 0));
        dest.writeInt(category);
        dest.writeString(progress);
        dest.writeByte((byte) (completed ? 1 : 0));
        dest.writeInt(startdate);
        dest.writeInt(enddate);
        dest.writeInt(marker);
        dest.writeString(lastaccess);
        dest.writeByte((byte) (isfavourite ? 1 : 0));
        dest.writeByte((byte) (hidden ? 1 : 0));
    }
}
