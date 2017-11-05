# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

set(CURRENT_DIR ${CMAKE_SOURCE_DIR})

add_library( avcodec
             SHARED
             IMPORTED )
set_target_properties( # Specifies the target library.
                       avcodec

                       # Specifies the parameter you want to define.
                       PROPERTIES IMPORTED_LOCATION

                       # Provides the path to the library you want to import.
                       ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavcodec-57.so )

add_library( avdevice SHARED IMPORTED )
set_target_properties( avdevice PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavdevice-57.so )

add_library( avfilter SHARED IMPORTED )
set_target_properties( avfilter PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavfilter-6.so )

add_library( avformat SHARED IMPORTED )
set_target_properties( avformat PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavformat-57.so )

add_library( avutil SHARED IMPORTED )
set_target_properties( avutil PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libavutil-55.so )

add_library( postproc SHARED IMPORTED )
set_target_properties( postproc PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libpostproc-54.so )

add_library( swresample SHARED IMPORTED )
set_target_properties( swresample PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswresample-2.so )

add_library( swscale SHARED IMPORTED )
set_target_properties( swscale PROPERTIES IMPORTED_LOCATION ${CURRENT_DIR}/src/main/jniLibs/${ANDROID_ABI}/libswscale-4.so )

include_directories(src/main/cpp/ffmpeg/include)

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )

target_link_libraries(native-lib avcodec avdevice avfilter avformat avutil postproc swresample swscale)