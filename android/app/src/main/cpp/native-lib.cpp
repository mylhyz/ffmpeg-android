#include <jni.h>
#include <string>

extern "C" {
#include "libavcodec/avcodec.h"
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_viper_android_ffmpeg_FFmpegInfoActivity_getConfigureInfo(
        JNIEnv *env, jclass type) {
    char info[1000] = {0};
    sprintf(info, "%s", avcodec_configuration());
    return env->NewStringUTF(info);
}