var TD_PLAIN = 'border:Solid #000000';

function buildDetalleRows(p) {
    var rows = '';

    rows += '<tr id="det-' + p.nombre + '" style="display:none"><th colspan="5">DATOS JUGADOR</th></tr>';
    rows += '<tr id="det-' + p.nombre + '-h" style="display:none">'
        + '<th>PLANTA</th>'
        + '<th>IMAGEN</th>'
        + '<th colspan="3">DATOS PLANTA</th>'
        + '</tr>';

    var ninisSorted = p.ninis.slice().sort(function (a, b) { return b.nombre.localeCompare(a.nombre); });
    for (var i = 0; i < ninisSorted.length; i++) {
        var n = ninisSorted[i];
        rows += '<tr id="det-' + p.nombre + '-n" style="display:none">'
            + '<td style="' + TD_PLAIN + '; color: #34e718;">' + n.nombre + '</td>'
            + '<td rowspan="2" style="' + TD_PLAIN + '"><img src="' + n.imagen + '"></td>'
            + '<td style="' + TD_PLAIN + '">Coste: ' + n.coste + '</td>'
            + '<td style="' + TD_PLAIN + '">Vida: ' + n.vida + '</td>'
            + '<td style="' + TD_PLAIN + '">Alcance de Ataque: ' + n.alcance + '</td>'
            + '</tr>';
        rows += '<tr id="det-' + p.nombre + '-n" style="display:none">'
            + '<td style="' + TD_PLAIN + '">' + n.descripcion + '</td>'
            + '<td style="' + TD_PLAIN + '">Radio de Ataque: ' + n.radio + '</td>'
            + '<td style="' + TD_PLAIN + '">Daño: ' + n.daño + '</td>'
            + '<td style="' + TD_PLAIN + '">Tipo de proyectil: ' + n.proyectil + '</td>'
            + '</tr>';
    }

    rows += '<tr id="det-' + p.nombre + '-s" style="display:none">'
        + '<td>Cosas Matadas : ' + p.cosasMatadas + '</td>'
        + '<td>Ninis muertos : ' + p.ninisMuertos + '</td>'
        + '<td>Ninis Eliminados : ' + p.ninisEliminados + '</td>'
        + '<td>Butanitos Totales : ' + p.butanitos + '</td>'
        + '<td>Puntuacion Total : ' + p.punt + '</td>'
        + '</tr>';

    rows += '<tr id="det-' + p.nombre + '-lh" style="display:none"><th colspan="5">LOGROS JUGADOR</th></tr>';



    rows += '<tr id="det-' + p.nombre + '-l1" style="display:none">';
    for (var j = 0; j < p.logros.length; j++) {
        var l = p.logros[j];
        if (l.id === '1' || l.id === '2' || l.id === '3') {
            var color = l.completado == 'Si' ? ' background-color: #6B99BF; color: #000000;' : ' ';
            rows += '<td colspan="2" style="' + TD_PLAIN + '; ' + color + '">'
                + 'Completado: ' + l.completado + '<br>'
                + 'Nombre Logro: ' + l.titulo + '<br>'
                + 'Minuto Obtenido: ' + l.minuto + '<br>'
                + 'Medalla: ' + l.tipoMedalla + '<br>'
                + 'Medalla Puntuacion: ' + l.puntuacionLogro
                + '</td>';
        }
    }
    rows += '</tr>';

    rows += '<tr id="det-' + p.nombre + '-l2" style="display:none">';
    for (var k = 0; k < p.logros.length; k++) {
        var l2 = p.logros[k];
        if (l2.id === '4' || l2.id === '5' || l2.id === '6') {
            var color2 = l2.completado == 'Si' ? ' background-color: #6B99BF; color: #000000;' : ' ';
            rows += '<td colspan="2" style="' + TD_PLAIN + '; ' + color2 + '">'
                + 'Completado: ' + l2.completado + '<br>'
                + 'Nombre Logro: ' + l2.titulo + '<br>'
                + 'Minuto Obtenido: ' + l2.minuto + '<br>'
                + 'Medalla: ' + l2.tipoMedalla + '<br>'
                + 'Medalla Puntuacion: ' + l2.puntuacionLogro
                + '</td>';
        }
    }
    rows += '</tr>';

    return rows;
}


function toggleDetalle(nombre) {
    var ids = [
        'det-' + nombre,
        'det-' + nombre + '-h',
        'det-' + nombre + '-s',
        'det-' + nombre + '-lh',
        'det-' + nombre + '-lh2',
        'det-' + nombre + '-l1',
        'det-' + nombre + '-l2'
    ];
    var niniRows = document.querySelectorAll('tr[id="det-' + nombre + '-n"]');
    var firstRef = document.getElementById('det-' + nombre);
    var show = firstRef.style.display === 'none';

    for (var i = 0; i < ids.length; i++) {
        var el = document.getElementById(ids[i]);
        if (el) el.style.display = show ? '' : 'none';
    }
    niniRows.forEach(function (r) { r.style.display = show ? '' : 'none'; });
}

var tbody = document.getElementById('ranking-body');
players.forEach(function (p, i) {
    var trTop = document.createElement('tr');
    trTop.innerHTML = '<th>' + (i + 1) + '</th>'
        + '<td><span onclick="toggleDetalle(\'' + p.nombre + '\')">' + p.nombre + '</span></td>'
        + '<td>' + p.punt + '</td>'
        + '<td>' + p.h + 'h : ' + p.m + 'm : ' + p.s + 's</td>'
        + '<td>' + p.dia + '/ ' + p.mes + '/ ' + p.año + '</td>';
    tbody.appendChild(trTop);

    var tmp = document.createElement('tbody');
    tmp.innerHTML = buildDetalleRows(p);
    while (tmp.firstChild) tbody.appendChild(tmp.firstChild);
});
