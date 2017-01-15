
package sri.universal.apis

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSImport

case class AsyncStorageException(err: js.Dynamic) extends Exception

object AsyncStorage {

  val SUCCESS: String = ""

  type CALLBACK = js.Function2[UndefOr[js.Dynamic], UndefOr[js.Dynamic], _]

  lazy val _AsyncStorageJS = AsyncStorageJS

  def getItem(key: String): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.getItem(key, (err: UndefOr[js.Dynamic], resp: UndefOr[String]) => {
      if (js.isUndefined(err) || err == null) promise.success(resp.get)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }

  def setItem(key: String, value: String): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.setItem(key, value, (err: UndefOr[js.Dynamic]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }


  def removeItem(key: String): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.removeItem(key, (err: UndefOr[js.Dynamic]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }

  def mergeItem(key: String, value: String): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.mergeItem(key, value, (err: UndefOr[js.Dynamic]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }

  def clear: Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.clear((err: UndefOr[js.Dynamic]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }

  def getAllKeys: Future[js.Array[String]] = {
    val promise = Promise[js.Array[String]]()
    _AsyncStorageJS.getAllKeys((err: UndefOr[js.Dynamic], resp: UndefOr[js.Array[String]]) => {
      if (js.isUndefined(err) || err == null) promise.success(resp.get)
      else promise.failure(AsyncStorageException(err.get))
    })
    promise.future
  }

  def multiGet(keys: js.Array[String]): Future[js.Array[js.Array[String]]] = {
    val promise = Promise[js.Array[js.Array[String]]]()
    _AsyncStorageJS.multiGet(keys, (err: UndefOr[js.Array[js.Dynamic]], resp: UndefOr[js.Array[js.Array[String]]]) => {
      if (js.isUndefined(err) || err == null) promise.success(resp.get)
      else promise.failure(AsyncStorageException(err.get.asInstanceOf[js.Dynamic]))
    })
    promise.future
  }

  def multiSet(keyValuePairs: js.Array[js.Array[String]]): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.multiSet(keyValuePairs, (err: UndefOr[js.Array[js.Dynamic]]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get.asInstanceOf[js.Dynamic]))
    })
    promise.future
  }

  def multiRemove(keys: js.Array[String]): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.multiRemove(keys, (err: UndefOr[js.Array[js.Dynamic]]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get.asInstanceOf[js.Dynamic]))
    })
    promise.future
  }

  def multiMerge(keyValuePairs: js.Array[js.Array[String]]): Future[String] = {
    val promise = Promise[String]()
    _AsyncStorageJS.multiMerge(keyValuePairs, (err: UndefOr[js.Array[js.Dynamic]]) => {
      if (js.isUndefined(err) || err == null) promise.success(SUCCESS)
      else promise.failure(AsyncStorageException(err.get.asInstanceOf[js.Dynamic]))
    })
    promise.future
  }


}

@js.native
trait AsyncStorageJS extends js.Object {

  def getItem(key: String, callback: js.Function2[UndefOr[js.Dynamic], UndefOr[String], _] = ???): Unit = js.native

  def setItem(key: String, value: String, callback: js.Function1[UndefOr[js.Dynamic], _] = ???): Unit = js.native

  def mergeItem(key: String, value: String, callback: js.Function1[UndefOr[js.Dynamic], _] = ???): Unit = js.native

  def removeItem(key: String, callback: js.Function1[UndefOr[js.Dynamic], _] = ???): Unit = js.native

  def clear(callback: js.Function1[UndefOr[js.Dynamic], _] = ???): Unit = js.native

  def getAllKeys(callback: js.Function2[UndefOr[js.Dynamic], UndefOr[js.Array[String]], _] = ???): Unit = js.native

  def multiGet(keys: js.Array[String], callback: js.Function2[UndefOr[js.Array[js.Dynamic]], UndefOr[js.Array[js.Array[String]]], _]): Unit = js.native

  def multiRemove(keys: js.Array[String], callback: js.Function1[UndefOr[js.Array[js.Dynamic]], _]): Unit = js.native

  def multiSet(keyValuePairs: js.Array[js.Array[String]], callback: js.Function1[UndefOr[js.Array[js.Dynamic]], _] = ???): Unit = js.native

  def multiMerge(keyValuePairs: js.Array[js.Array[String]], callback: js.Function1[UndefOr[js.Array[js.Dynamic]], _] = ???): Unit = js.native

}

@js.native
@JSImport("react-native","AsyncStorageJS")
object AsyncStorageJS extends AsyncStorageJS