@file:Suppress("unused")

package jQueryInterface

import org.w3c.dom.Element
import org.w3c.dom.Window
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventTarget
import org.w3c.xhr.XMLHttpRequest
import kotlin.js.*


typealias EventHandler = (Event?) -> Unit



/**
 * @author Ben Leggiero
 * @since 2017-11-25
 */
external class JQuery {

    /**
     * Adds the specified class(es) to each element in the set of matched elements.
     *
     * See also: http://api.jquery.com/addClass/#addClass-className
     *
     * @param className One or more space-separated classes to be added to the class attribute of each matched element.
     *
     * @return jQuery
     */
    fun addClass(className: String): JQuery
    fun addClass(transformer: (index: Int, existingClass: String) -> String): JQuery

    fun attr(attrName: String): Any?
    fun attr(attrName: String, value: String?): JQuery
    fun attr(attrName: String, value: Double?): JQuery
    fun attr(attrName: String, value: Boolean?): JQuery
    fun prop(propertyName: String): Any?
    fun prop(propertyName: String, value: String?): JQuery
    fun prop(propertyName: String, value: Double?): JQuery
    fun prop(propertyName: String, value: Boolean?): JQuery
    fun removeProp(propertyName: String): JQuery
    fun data(): Map<String, Any>
    fun data(key: String): Any?
    fun data(key: String, value: Any?): JQuery
    fun data(keyValuePairs: Map<String, Any>): JQuery
    fun `val`(): String?
    fun `val`(newValue: String?): JQuery
    fun `val`(newValue: Double?): JQuery
    fun `val`(newValue: Array<*>?): JQuery


    fun html(): String
    fun html(s: String): JQuery
    fun html(f: (Int, String) -> String): JQuery


    fun hasClass(className: String): Boolean
    fun removeClass(className: String): JQuery
    fun height(): Number
    fun width(): Number


    fun click(): JQuery

    fun mousedown(handler: (MouseEvent) -> Unit): JQuery
    fun mouseup(handler: (MouseEvent) -> Unit): JQuery
    fun mousemove(handler: (MouseEvent) -> Unit): JQuery

    fun dblclick(handler: (MouseClickEvent) -> Unit): JQuery
    fun click(handler: (MouseClickEvent) -> Unit): JQuery

    fun on(eventNames: String, selector: String = definedExternally, handler: (Event) -> Unit)
    fun <T> on(eventNames: String, selector: String = definedExternally, data: T? = definedExternally, handler: (Event, T?) -> Unit)

    fun trigger(eventName: String): JQuery
    fun trigger(event: Event): JQuery

    fun select(): JQuery
    fun select(eventData: Any? = definedExternally, handler: (Event) -> Unit): JQuery

    fun load(handler: EventHandler): JQuery
    fun change(handler: EventHandler): JQuery

    fun append(vararg str: String): JQuery
    fun append(vararg str: Element): JQuery
    fun append(vararg str: Array<String>): JQuery
    fun append(vararg str: Array<Element>): JQuery
    fun append(vararg str: JQuery): JQuery
    fun append(str: (index: Int, html: String) -> String): JQuery
    fun append(str: (index: Int, html: String) -> Element): JQuery
    fun append(str: (index: Int, html: String) -> JQuery): JQuery
    fun before(content: String): JQuery
    fun before(content: JQuery): JQuery
    /**
     * Remove the set of matched elements from the DOM.
     *
     * Similar to `.empty()`, the `.remove()` method takes elements out of the DOM. Use `.remove()` when you want to
     * remove the element itself, as well as everything inside it. In addition to the elements themselves, all bound
     * events and jQuery data associated with the elements are removed. To remove the elements without removing data
     * and events, use `.detach()` instead.
     */
    fun remove(): JQuery
    fun empty(): JQuery
    fun detach(): JQuery
    fun ready(handler: EventHandler): JQuery
    fun text(text: String): JQuery
    fun slideUp(): JQuery
    fun hover(handlerInOut: EventHandler): JQuery
    fun hover(handlerIn: EventHandler, handlerOut: EventHandler): JQuery
    fun prev(): JQuery
    fun next(): JQuery
    fun parent(): JQuery

    fun off(): JQuery

    fun toArray(): Array<Element>
    fun <To> map(mapper: JQueryMapper<To>): Array<To>

    val length: Int
    @Deprecated(message = "The .size() method is deprecated as of jQuery 1.8. Use the .length property instead.",
                replaceWith = ReplaceWith("length"),
                level = DeprecationLevel.ERROR)
    fun size(): Int

    operator fun get(index: Int): Element
}



typealias JQueryMapper<To> = (index: Int, element: Element) -> To



typealias GetJsonSuccess = (data: Json, textStatus: String, jqXHR: jqXHR) -> Unit


open external class MouseEvent : Event {
    val pageX: Double
    val pageY: Double
    //    public fun preventDefault()
    fun isDefaultPrevented(): Boolean
}

external class MouseClickEvent : MouseEvent {
    val which: Int
}

@JsName("$")
external fun jq(selector: String): JQuery

@JsName("$")
external fun jq(selector: String, context: Element): JQuery

@JsName("$")
external fun jq(selector: String, context: JQuery): JQuery

@JsName("$")
external fun jq(callback: () -> Unit): JQuery

@JsName("$")
external fun jq(selection: JQuery): JQuery

@JsName("$")
external fun jq(element: Element): JQuery

@JsName("$")
external fun jq(window: Window): JQuery

@JsName("$")
external fun jq(): JQuery

@JsName("$")
external val jq: JQueryStatic



@Suppress("UnsafeCastFromDynamic")
inline val EventTarget.parentElement: Element
    get() = asDynamic().parentElement



external class jqXHR: XMLHttpRequest



@JsName("$")
external object JQueryStatic {

    /**
     * Load JSON-encoded data from the server using a GET HTTP request.
     *
     * http://api.jquery.com/jQuery.getJSON/
     *
     * @param url     A string containing the URL to which the request is sent.
     * @param data    A plain object or string that is sent to the server with the request.
     * @param success A callback function that is executed if the request succeeds.
     */
    fun getJSON(url: String,
                data: String = definedExternally,
                success: GetJsonSuccess = definedExternally)
}
