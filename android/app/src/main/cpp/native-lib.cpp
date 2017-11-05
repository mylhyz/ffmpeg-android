#include <jni.h>
#include <string>

extern "C" {
#include "libavcodec/avcodec.h"
#include "libavformat/avformat.h"
#include "libavfilter/avfilter.h"
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getConfigureInfo(
        JNIEnv *env, jclass type) {
    char info[1000] = {0};
    sprintf(info, "%s", avcodec_configuration());
    return env->NewStringUTF(info);
}

struct URLProtocol;

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getSupportedProtocol(
        JNIEnv *env, jclass type) {
    char info[10000] = {0};
    av_register_all();
    struct URLProtocol *pup = NULL;
    struct URLProtocol **temp_pup = &pup;
    avio_enum_protocols((void **) temp_pup, 0);
    while ((*temp_pup) != NULL) {
        sprintf(info, "%s[In ][%10s]\n", info, avio_enum_protocols((void **) temp_pup, 0));
    }
    pup = NULL;
    avio_enum_protocols((void **) temp_pup, 1);
    while ((*temp_pup) != NULL) {
        sprintf(info, "%s[Out ][%10s]\n", info, avio_enum_protocols((void **) temp_pup, 0));
    }
    return env->NewStringUTF(info);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getSupportedFormat(
        JNIEnv *env, jclass type) {
    char info[10000] = {0};
    av_register_all();
    AVInputFormat *if_tmp = av_iformat_next(NULL);
    AVOutputFormat *of_tmp = av_oformat_next(NULL);
    while (if_tmp != NULL) {
        sprintf(info, "%s[In ][%10s]\n", info, if_tmp->name);
        if_tmp = if_tmp->next;
    }
    while (of_tmp != NULL) {
        sprintf(info, "%s[Out][%10s]\n", info, of_tmp->name);
        of_tmp = of_tmp->next;
    }
    return env->NewStringUTF(info);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getSupportedCodec(
        JNIEnv *env, jclass type) {
    char info[40000] = {0};
    av_register_all();
    AVCodec *c_tmp = av_codec_next(NULL);
    while (c_tmp != NULL) {
        if (c_tmp->decode != NULL) {
            sprintf(info, "%s[Dec]", info);
        } else {
            sprintf(info, "%s[Enc]", info);
        }

        switch (c_tmp->type) {
            case AVMEDIA_TYPE_VIDEO:
                sprintf(info, "%s[Video]", info);
                break;
            case AVMEDIA_TYPE_AUDIO:
                sprintf(info, "%s[Audio]", info);
                break;
            default:
                sprintf(info, "%s[Other]", info);
                break;
        }
        sprintf(info, "%s[%10s]\n", info, c_tmp->name);
        c_tmp = c_tmp->next;
    }

    return env->NewStringUTF(info);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getSupportedFilter(
        JNIEnv *env, jclass type) {
    char info[10000] = {0};
    avfilter_register_all();
    AVFilter *f_tmp = (AVFilter *) avfilter_next(NULL);
    while (f_tmp != NULL) {
        sprintf(info, "%s[%10s]\n", info, f_tmp->name);
        f_tmp = f_tmp->next;
    }
    return env->NewStringUTF(info);
}