import React from "react";

const Footer = () => {
  return (
    <footer className="text-gray-400 text-sm px-2">
      <div className="space-y-2">
        <a href="#" className="block hover:underline">Reglas de ConnectForo</a>
        <a href="#" className="block hover:underline">Política de privacidad</a>
        <a href="#" className="block hover:underline">Acuerdo de usuario</a>
        <a href="#" className="block hover:underline">Centro de ayuda</a>
      </div>
      <div className="mt-4">&copy; 2025 ConnectForo. Todos los derechos reservados.</div>
    </footer>
  );
};

export default Footer;
