package com.example.programmercalculator

class ConvertionOperations() {
    public fun ConvertFromDecimalToBinary(input: String): String {
        var decimal = input.toInt()

        return Integer.toBinaryString(decimal)


    }

    public fun ConvertDecimalToOctal(input: String): String {
        return Integer.toOctalString(input.toInt())
    }

    public fun ConvertDecimalToHex(input: String): String {
        return Integer.toHexString(input.toInt())
    }

    public fun ConvertBinaryToDecimal(input: String): String {
        var binaryN = input.toLong()
        var decimalNum: Long = 0
        if (checkBinary(binaryN)) {
            var n = binaryN

            var base = 1
            while (n != 0.toLong()) {
                val lastDigit = n % 10
                n /= 10
                decimalNum += lastDigit * base
                base *= 2
            }
        }
        return decimalNum.toString()

    }

    private fun checkBinary(binaryNum: Long): Boolean {
        var isBinary = true

        var n = binaryNum
        while (n != 0.toLong()) {
            val lastDigit = n % 10
            if (!((lastDigit == 0.toLong()) || (lastDigit == 1.toLong()))) {
                isBinary = false
                break
            }
            n /= 10
        }
        return isBinary
    }


    public fun ConvertBinaryToHex(input: String): String {
        var bytes = input.toByteArray()
        val hexArray = "0123456789ABCDEF".toCharArray()
        val hexChars = CharArray(bytes.size * 2)
        for (j in bytes.indices) {
            val v = bytes[j].toInt() and 0xFF

            hexChars[j * 2] = hexArray[v ushr 4]
            hexChars[j * 2 + 1] = hexArray[v and 0x0F]
        }
        return String(hexChars)
    }

    public fun ConvertBinaryToOctal(input: String): String {
        var binaryNumber = input.toLong()
        var octalNumber = 0
        var decimalNumber = 0
        var i = 0

        while (binaryNumber.toInt() != 0) {
            decimalNumber += (binaryNumber % 10 * Math.pow(2.0, i.toDouble())).toInt()
            ++i
            binaryNumber /= 10
        }

        i = 1

        while (decimalNumber != 0) {
            octalNumber += decimalNumber % 8 * i
            decimalNumber /= 8
            i *= 10
        }

        return octalNumber.toString()
    }

    public fun ConvertHexToBinary(input: String): String {
        var binaryNum = ""
        var i = 0
        while (i < input.length) {
            when (input[i]) {
                '0' -> binaryNum += "0000"
                '1' -> binaryNum += "0001"
                '2' -> binaryNum += "0010"
                '3' -> binaryNum += "0011"
                '4' -> binaryNum += "0100"
                '5' -> binaryNum += "0101"
                '6' -> binaryNum += "0110"
                '7' -> binaryNum += "0111"
                '8' -> binaryNum += "1000"
                '9' -> binaryNum += "1001"
                'A' -> binaryNum += "1010"
                'B' -> binaryNum += "1011"
                'C' -> binaryNum += "1100"
                'D' -> binaryNum += "1101"
                'E' -> binaryNum += "1110"
                'F' -> binaryNum += "1111"
            }
            i++
        }

    return  binaryNum

}

    public fun ConvertHexToDecimal(input: String) :String{
            var i = input.length - 1
            var decimalN: Long = 0
            var base = 1
            while(i >= 0) {
                val charAtPos = input[i]

                val lastDigit = if((charAtPos >= '0') && (charAtPos <= '9')) {
                    charAtPos - '0'
                } else if((charAtPos >= 'A') && (charAtPos <= 'F')) {
                    charAtPos.toInt() - 55
                } else if((charAtPos >= 'a') && (charAtPos <= 'f')) {
                    charAtPos.toInt() - 87
                } else {
                    0
                }

                decimalN += lastDigit * base
                base *= 16

                i--
            }
            return decimalN.toString()
        }

    public fun ConvertHexToOctal(input: String) : String{
        var fromHexToBinay= ConvertHexToBinary(input)
        var fromBinaryToOctal=ConvertBinaryToOctal(fromHexToBinay)
        return fromBinaryToOctal
    }

    public fun ConvertOctalToBinary(input: String):String{
        var octalNumber = input.toInt()
        var decimalNumber = 0
        var i = 0
        var binaryNumber: Long = 0

        while (octalNumber != 0) {
            decimalNumber += (octalNumber % 10 * Math.pow(8.0, i.toDouble())).toInt()
            ++i
            octalNumber /= 10
        }

        i = 1

        while (decimalNumber != 0) {
            binaryNumber += (decimalNumber % 2 * i).toLong()
            decimalNumber /= 2
            i *= 10
        }

        return binaryNumber.toString()
    }

    public fun ConvertOctalToDecimal(input: String) : String{
        var fromOctalToBinary=ConvertOctalToBinary(input)
        var fromBinaryToDecimal=ConvertBinaryToDecimal(fromOctalToBinary)
        return fromBinaryToDecimal

    }

    public fun ConvertOctalToHex(input: String):String{
        var fromOctalToBinary=ConvertOctalToBinary(input)
        var fromBinaryToHex=ConvertBinaryToHex(fromOctalToBinary)
        return fromBinaryToHex
    }
}