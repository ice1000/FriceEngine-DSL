package org.frice.dsl.extension

import org.frice.obj.sub.ShapeObject
import org.frice.resource.graphics.ColorResource
import org.frice.utils.shape.FShapeInt

/**
 * Provide sth that is needed by DSL
 * Created by ice1000 on 2016/9/29.
 *
 * @author ice1000
 */
class DSLShapeObject(res: ColorResource, shape: FShapeInt) : ShapeObject(res, shape) {
	var color
		get() = res
		set(value) {
			res = value
		}

	var 颜色
		get() = color
		set(值) {
			color = 值
		}
	var 宽
		get() = width
		set(值) {
			width = 值
		}
	var 高
		get() = height
		set(值) {
			height = 值
		}
}

