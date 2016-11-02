package pong

class PongTagLib {
  static final namespace = 'pong'
  static defaultEncodeAs = [taglib:'html']
  //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

  def ack = {attrs ->
    def ping = attrs.remove('ping')
    out << "PONG got you saying '${ping}'"
  }
}
