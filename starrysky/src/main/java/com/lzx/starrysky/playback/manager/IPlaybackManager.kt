package com.lzx.starrysky.playback.manager

import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat

import com.lzx.starrysky.notification.INotification
import com.lzx.starrysky.provider.MediaQueueProvider

interface IPlaybackManager {

    val mediaSessionCallback: MediaSessionCompat.Callback

//    /**
//     * 是否在播放
//     */
//    val isPlaying: Boolean

    fun setServiceCallback(serviceCallback: PlaybackServiceCallback)

    fun setMetadataUpdateListener(listener: MediaQueueProvider.MetadataUpdateListener)

    fun setPlayStatusChanged(playStatusChanged: PlaybackManager.PlayStatusChanged)

    fun getPlayStatusChanged(): PlaybackManager.PlayStatusChanged?

    /**
     * 是否存在上一首
     */
    fun isExistLast(): Boolean

    /**
     * 是否存在下一首
     */
    fun isExistNext(): Boolean

    /**
     * 获取当前播放的索引
     */
    fun getPlayIndex(): Int

    /**
     * 设置当前播放的索引
     */
    fun setPlayIndex(index: Int)


    /**
     * 设置当前是否在播放
     */
    fun setPlaying(isPlay: Boolean)

    /**
     * 设置当前是否暂停
     */
    fun setPause(isPause: Boolean)


    /**
     * 设置当前是否停止
     */
    fun setStop(isPause: Boolean)


    /**
     * 获取当前是否在暂停
     */
    val isPause: Boolean

    /**
     * 获取当前是否停止播放
     */
    val isStop: Boolean

    /**
     * 获取当前是否在播放
     */
    val isPlaying: Boolean

    /**
     * 播放
     */
    fun handlePlayRequest(isPlayWhenReady: Boolean)

    /**
     * 暂停
     */
    fun handlePauseRequest()

    /**
     * 停止
     */
    fun handleStopRequest(withError: String?)

    /**
     * 快进
     */
    fun handleFastForward()

    /**
     * 倒带
     */
    fun handleRewind()

    /**
     * 指定语速 refer 是否已当前速度为基数  multiple 倍率
     */
    fun handleDerailleur(refer: Boolean, multiple: Float)

    /**
     * 更新播放状态
     */
    fun updatePlaybackState(isOnlyUpdateActions: Boolean, error: String?)

    fun registerNotification(notification: INotification)

    interface PlaybackServiceCallback {
        fun onPlaybackStart()

        fun onNotificationRequired()

        fun onPlaybackStop()

        fun onPlaybackStateUpdated(
                newState: PlaybackStateCompat, currMetadata:
                MediaMetadataCompat?
        )

        fun onShuffleModeUpdated(shuffleMode: Int)

        fun onRepeatModeUpdated(repeatMode: Int)
    }
}
