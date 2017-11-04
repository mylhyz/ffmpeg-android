#!/bin/bash

#
# build ffmpeg for android only for arm64(armeabi-v8a)
#

#参考 https://developer.android.google.cn/ndk/guides/standalone_toolchain.html

ANDROID_NDK_HOME=$HOME/Android/Sdk/ndk-bundle
#NDK环境变量
NDK=$ANDROID_NDK_HOME
#生成文件安装路径
PREFIX=$(pwd)/build/android
#交叉编译工具链
TOOLCHAIN=$NDK/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64
#交叉编译头文件和库文件搜索路径
SYSROOT=$NDK/platforms/android-21/arch-arm64
#交叉编译器命名前缀
CROSS_PREFIX=$TOOLCHAIN/bin/aarch64-linux-android-

build_configure(){

$(pwd)/ffmpeg-3.3.5/configure \
	--prefix=$PREFIX \
	--sysroot=$SYSROOT \
	--enable-cross-compile \
	--cross-prefix=$CROSS_PREFIX \
	--target-os=linux \
	--arch=arm64 \
	--enable-gpl \
	--enable-version3 \
	--disable-symver \
	--enable-shared \
	--disable-programs \
	--disable-doc \

}

echo $PREFIX
echo $NDK
echo $TOOLCHAIN
echo $CROSS_PREFIX
echo $SYSROOT

build_configure
